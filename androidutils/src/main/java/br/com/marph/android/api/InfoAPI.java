package br.com.marph.android.api;

import com.android.volley.Response;

/**
 * Interface responsável por conter os dados de conexão a uma API.
 *
 * @author joao.oliveira
 */
public interface InfoAPI extends Response.ErrorListener {

    /**
     * Retorna a URL de conexão ao servidor
     *
     * @return String contendo a URL da API
     */
    public String getWsURL();

    /**
     * Retorna a Class do tipo de retorno da API
     *
     * @return Class que será o retorno da API
     */
    public Class<? extends Object> getApiReturnClass();

    /**
     * Método responsável por executar o response do Webservice caso a requisição seja efetuada
     *
     * @param jsonParser Objeto retornado pelo Webservice
     */
    public void doResponse(Object jsonParser);

}
