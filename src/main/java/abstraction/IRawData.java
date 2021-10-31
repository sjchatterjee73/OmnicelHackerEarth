package abstraction;

import java.util.List;

import org.json.JSONObject;

import datas.OmnicelData;

public interface IRawData {
	public List<JSONObject> getAllObjects();

	public JSONObject getSingleObject(int id);

	public void insertItem(int id);

	public void insertItem(OmnicelData data);
}
