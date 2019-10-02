package uf1;

import java.util.*;

public class TestHashMap {
	public static void main(String[] args) {
		String cod_banco;
		Map<String, String> bancos = new HashMap<String, String>();
		bancos.put("1827", "BBVA");
		bancos.put("0049", "Santander");
		bancos.put("2038", "Bankia");
		bancos.put("2100", "La Caixa");
		Iterator<String> it = bancos.keySet().iterator();
		while (it.hasNext()) {
			cod_banco = (String) it.next();
			System.out.println(cod_banco + ": " + bancos.get(cod_banco));

		}

	}
}
