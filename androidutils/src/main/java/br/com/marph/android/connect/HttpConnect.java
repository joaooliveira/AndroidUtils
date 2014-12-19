package br.com.marph.android.connect;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.marph.android.api.InfoAPI;
import br.com.marph.android.app.AppController;
import br.com.marph.android.exceptions.WSException;
import br.com.marph.android.util.JSONUtils;

/**
 * Classe responsável por fazer a conexão a um determinada URL enviando os
 * parametros especificados e retornando um Objeto parser de JSON como resposta.
 *
 * @author joao.oliveira
 */
public class HttpConnect {

    private static final String UTF_8 = "UTF-8";
    private static final String TAG = "HTTP_CONNECT";

    /**
     * Método responsável por fazer a conexão a uma determinada URL sem envio de
     * parametro. Após a execução, o metodo doResponse da InfoAPI é chamado.
     *
     * @param infoAPI objeto contendo a URL de conexão e o tipo de objeto de retorno
     * @return um novo objeto com o conteudo de retorno informado pela conexão.
     * Caso não haja resposta será retornado null.
     * @throws br.com.marph.android.exceptions.WSException qualquer erro que acontecer durante a execução
     */
    public static void getContent(InfoAPI infoAPI) throws WSException {
        getContent(infoAPI, null);
    }

    /**
     * Método responsável por fazer a conexão a uma determinada URL com envio de
     * parametro. Após a execução, o metodo doResponse da InfoAPI é chamado.
     *
     * @param infoAPI   objeto contendo a URL de conexão e o tipo de objeto de retorno
     * @param parameter objeto contendo os dados para envio, eles serão enviados
     *                  como JSON.
     * @throws br.com.marph.android.exceptions.WSException qualquer erro que acontecer durante a execução
     */
    public static void getContent(final InfoAPI infoAPI, Object parameter) throws WSException {
        Log.i(TAG, "Acessando URL [" + infoAPI.getWsURL() + "]");
        JSONObject json = null;
        if (parameter != null) {
            try {
                Log.d(TAG, "Convertendo JSON");
                String j = JSONUtils.toJson(parameter);
                Log.d(TAG, "JSON Convertido [" + j + "]");
                json = new JSONObject(j);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, infoAPI.getWsURL(), json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                infoAPI.doResponse(JSONUtils.fromJson(response.toString(), infoAPI.getApiReturnClass()));
            }
        }, infoAPI);
        Log.d(TAG, "Adicionando na fila");
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
}
