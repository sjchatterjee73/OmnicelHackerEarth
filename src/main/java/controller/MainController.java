package controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import abstraction.IRawData;
import datas.OmnicelData;

@RestController
public class MainController {
	@Autowired
	IRawData iRawData;	
	@GetMapping (value = "/")
	public ResponseEntity<String> getRawRecords() {
		List<JSONObject> jsons = iRawData.getAllObjects();
		JSONArray array = new JSONArray();
		for(JSONObject o : jsons) {
			System.out.println(o);
			array.put(o);
		}
		return new ResponseEntity(array.toString(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public String getSingleRecord(@PathVariable int id){
		JSONObject obj = iRawData.getSingleObject(id);
		return obj.toString();
	}
	
	@GetMapping(value = "/{id}/{show}")
	public String getUrl(@PathVariable int id, @PathVariable String show) {
		String url = "";
		System.out.println("id >> type >> "+id + " >> "+show);
		JSONObject object = iRawData.getSingleObject(id);
		
		if("show".equals(show)) {
			url = object.getString("imageUrl");
		}
		
		return url;
	}	
	
	@PostMapping(value = "/")
	public void addValues(@RequestBody OmnicelData data) {
		iRawData.insertItem(data);
	}
}
