package controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Profissional;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.ContatoService;
import services.ProfissionalService;

public class ProfissionalController extends Controller {

	static Form<Profissional> profissionalForm = Form.form(Profissional.class);

	public Result jsonResult(Result httpResponse) {
		response().setContentType("application/json; charset=utf-8");
		return httpResponse;
	}

	@Transactional(readOnly = true)
	public Result getById(Long id) {
		Profissional profissional = ProfissionalService.getById(id);
		if (profissional == null) {
			ObjectNode result = Json.newObject();
			result.put("erro", "Não encontrado -> " + id);
		}
		return jsonResult(ok(Json.toJson(profissional)));
	}

	@Transactional
	public Result create() {
		Form<Profissional> profissional = profissionalForm.bindFromRequest();
		if (profissional.hasErrors()) {
			return jsonResult(badRequest(profissional.errorsAsJson()));
		}
		Profissional novoProfissional = ProfissionalService.create(profissional.get());
		jsonResult(created(Json.toJson(novoProfissional)));

		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
		mapper.setDateFormat(outputFormat);
		Json.setObjectMapper(mapper);

		return jsonResult(ok(Json.toJson("Profissional cadastrado com sucesso!")));
	}

	@Transactional
	public Result update() {
		Form<Profissional> profissional = profissionalForm.bindFromRequest();
		if (profissional.hasErrors()) {
			return jsonResult(badRequest(profissional.errorsAsJson()));
		}
		Profissional updateProfissional = ProfissionalService.update(profissional.get());
		jsonResult(ok(Json.toJson(updateProfissional)));

		return jsonResult(ok(Json.toJson("Cadastro alterado com sucesso!")));
	}

	@Transactional
	public Result delete(Long id) {
		if (ProfissionalService.delete(id)) {
			return jsonResult(ok(Json.toJson("Profissional excluído com sucesso!")));
		}
		ObjectNode result = Json.newObject();
		result.put("erro", "Profissional não encontrado -> " + id);
		return jsonResult(notFound(result));
	}

	@Transactional(readOnly = true)
	public Result listAll() {
		List profissionais = ProfissionalService.listAll();
		ObjectNode result = Json.newObject();

		result.put("Lista de profissionais", Json.toJson(profissionais));
		return jsonResult(ok(result));
	}
	
	@Transactional(readOnly = true)
	public Result listByParam(String param) {
		List profissionais = ProfissionalService.listByParam(param);
		ObjectNode result = Json.newObject();

		result.put("Lista de profissionais buscados por " + param, Json.toJson(profissionais));
		return jsonResult(ok(result));
	}
}
