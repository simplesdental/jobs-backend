package controllers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Contato;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.ContatoService;

public class ContatoController extends Controller {

	static Form<Contato> contatoForm = Form.form(Contato.class);

	public Result jsonResult(Result httpResponse) {
		response().setContentType("application/json; charset=utf-8");
		return httpResponse;
	}

	@Transactional(readOnly = true)
	public Result getById(Long id) {
		Contato contato = ContatoService.getById(id);
		if (contato == null) {
			ObjectNode result = Json.newObject();
			result.put("erro", "Não encontrado -> " + id);
			return jsonResult(notFound(result));
		}
		return jsonResult(ok(Json.toJson(contato)));
	}

	@Transactional
	public Result create() {
		Form<Contato> contato = contatoForm.bindFromRequest();
		if (contato.hasErrors()) {
			return jsonResult(badRequest(contato.errorsAsJson()));
		}
		Contato novoContato = ContatoService.create(contato.get());
		jsonResult(created(Json.toJson(novoContato)));

		return jsonResult(ok(Json.toJson("Contato cadastrado com sucesso!")));
	}

	@Transactional
	public Result update() {
		Form<Contato> contato = contatoForm.bindFromRequest();
		if (contato.hasErrors()) {
			return jsonResult(badRequest(contato.errorsAsJson()));
		}
		Contato updateContato = ContatoService.update(contato.get());
		jsonResult(ok(Json.toJson(updateContato)));

		return jsonResult(ok(Json.toJson("Cadastro alterado com sucesso!")));
	}

	@Transactional
	public Result delete(Long id) {
		if (ContatoService.delete(id)) {
			return jsonResult(ok(Json.toJson("Contato excluído com sucesso!")));
		}
		ObjectNode result = Json.newObject();
		result.put("erro", "Contato não encontrado -> " + id);
		return jsonResult(notFound(result));
	}

	@Transactional(readOnly = true)
	public Result listAll() {
		List contatos = ContatoService.listAll();
		ObjectNode result = Json.newObject();

		result.put("Lista de contatos", Json.toJson(contatos));
		return jsonResult(ok(result));
	}
	
	@Transactional(readOnly = true)
	public Result listByParam(String param) {
		List contatos = ContatoService.listByParam(param);
		ObjectNode result = Json.newObject();

		result.put("Lista de contatos buscados por " + param, Json.toJson(contatos));
		return jsonResult(ok(result));
	}
}
