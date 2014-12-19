package br.com.marph.android.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe utilitária com métodos que irão auxiliar no parse e na criação de JSON's
 * @author bruno.everton
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class JSONUtils {
	private static Gson gson;

	private static Gson getGson() {
		if (gson == null) {
			final GsonBuilder gsonBuilder = new GsonBuilder();
			gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		}
		return gson;
	}

	/**
	 * Método que irá criar um novo objeto baseado nos valores informados em um JSON.
	 * @param valor JSON contendo o dados para o objeto
	 * @param classe tipo de objeto a ser criado
	 * @return um novo objeto contendo os dados informados no JSON
	 */
	public static Object fromJson(String valor, Class classe) {
		synchronized (Gson.class) {
			Gson gson = getGson();
			return (Object) gson.fromJson(valor, classe);
		}
	}

	/**
	 * Método responsável por criar um JSON baseado no objeto informado
	 * @param baseVO objeto contendo os valores para o JSON
	 * @return String contendo o JSON criado
	 */
	public static String toJson(Object baseVO) {
		try {
			synchronized (Gson.class) {
				Gson gson = getGson();
				return gson.toJson(baseVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} catch (Error e) {
			e.printStackTrace();
			return null;
		}
	}

}
