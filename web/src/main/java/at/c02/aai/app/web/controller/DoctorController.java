package at.c02.aai.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import at.c02.aai.app.service.DoctorImportService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorImportService doctorImportService;

	@PutMapping("/import")
	@ResponseBody
	public List<at.c02.aai.app.web.api.in.DoctorDTO> importDoctors(
			@RequestBody List<at.c02.aai.app.web.api.in.DoctorDTO> doctors) {
		return doctorImportService.importDoctors(doctors);
	}
}
