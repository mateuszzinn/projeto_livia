package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.example.controller.GerenteController;
import org.example.model.Cliente;
import org.example.utils.paths.Path;
import org.example.view.TelaCadastroGerente;
import org.example.view.TelaLogin;

public class Main {

	public static void main(String[] args) throws IOException {

		File file = new File(Path.GERENTE_PATH);
		if (file.exists()) {
			new TelaLogin();
		} else {
			new TelaCadastroGerente();
		}

	}
}
