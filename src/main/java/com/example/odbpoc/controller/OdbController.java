package com.example.odbpoc.controller;

import com.example.odbpoc.ODBToJsonConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import org.jruby.javasupport.JavaEmbedUtils;

@RestController
public class OdbController {

	@GetMapping("/getJsonFromOdb")
	public List<Map<String, String>> getJsonfromOdb(@RequestParam("file") MultipartFile uploadedFile) throws IOException, InterruptedException {

		String line;
		BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(uploadedFile.getInputStream()));

		List<Map<String,String>> jsonList= new ArrayList<>();
		while ((line = bufferedReader.readLine()) != null) {
			jsonList.add(ODBToJsonConverter.convertFeaturesToJson(line));
		}
		return  jsonList;
	}
}