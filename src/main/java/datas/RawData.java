package datas;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import abstraction.IOmnicelDAO;
import abstraction.IRawData;

@Component
public class RawData implements IRawData{
	@Autowired
	IOmnicelDAO iOmnicelDAO;
	
	@Override
	public List<JSONObject> getAllObjects() {
		Integer [] ids = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		String [] names = {"Uthappizza", "Zucchipakoda", "Vadonut", "Guntur chillies", "Buffalo Paneer", "Cherry Tomatoes", "Goat Milk", "Rose breasted Grosbeak chicken", "Toenail Zingy"};
		String [] imageUrls = {"https://i.imgur.com/tDnjTXf.jpg", "https://i.imgur.com/xkUElXq.jpg", "https://i.imgur.com/anUAlqF.jpg", "https://i.imgur.com/Vc9JIXP.jpg", "https://i.imgur.com/pH2tkgk.jpg", "https://i.imgur.com/fRy8hjE.jpg", "https://i.imgur.com/zFGPhrI.jpg", "Rose breasted Grosbeak chicken", "https://i.imgur.com/IpG3YOT.jpg"};
		String [] category = {"mains", "appetizer", "appetizer", "dessert", "appetizer", "appetizer", "clone", "weird", "appetizer", "appetizer"};
		String [] labels = {"Hot", "", "New", "", "Spicy", "", "clone", "weird", "new", "weird"};
		Double [] prices = {4.99, 1.99, 1.99, 2.99, 0.99, 5.99, 9.99, 7.99, 0.99};
		String [] description = {"A unique combination of Indian Uthappam (pancake) and Italian pizza",
								 "Deep fried Zucchini coated with mildly spiced Chickpea flour batter accompanied with a sweet-tangy tamarind sauce",
								 "A quintessential ConFusion experience, is it a vada or is it a donut?",
								 "A delectable, semi-sweet New York Style Cheese Cake, with Graham cracker crust and spiced with Indian cardamoms",
								 "Assorted chillies from Guntur",
								 "A special type of Paneer made from Buffalo milk",
								 "clone of cherry and tomato",
								 "Medicinal Goat Milk",
								 "Roasted rare bird",
								 "Cooked Toenails of various animals"};
		
		Integer value = iOmnicelDAO.getAllRecords();
		System.out.println("values >> " + value);
		if(value == 0) {
			iOmnicelDAO.insertRecordsFirstTime(ids, names, imageUrls, category, labels, prices, description);
		}
		List<JSONObject> result = new ArrayList<>();
		for(int i=0; i<9; i++) {
			JSONObject json = new JSONObject();
			json.put("id", ids[i]);
			json.put("name", names[i]);
			json.put("image", imageUrls[i]);
			json.put("category", category[i]);
			json.put("label", labels[i]);
			json.put("price", prices[i]);
			json.put("description", description[i]);
			result.add(json);
		//	System.out.println(json.toString());
		}
		return result;
	}

	@Override
	public JSONObject getSingleObject(int id) {
		System.out.println("getSingleObject >> "+id);
		OmnicelData obj = iOmnicelDAO.getSingleRecord(id);
		JSONObject jsonObject = new JSONObject(obj);
		return jsonObject;
	}

	@Override
	public void insertItem(int id) {
		/* insert item associated with id; to insert values for all columns we should pass all values as string/any other format */
		System.out.println("demo > "+id);
		iOmnicelDAO.insertSingleRecord(id);
	}

	@Override
	public void insertItem(OmnicelData data) {
		iOmnicelDAO.insertSingleRecord(data);
	}

}
