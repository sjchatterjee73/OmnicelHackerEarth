package abstraction;

import datas.OmnicelData;

public interface IOmnicelDAO {
	public Integer getAllRecords();

	public void insertRecordsFirstTime(Integer[] ids, String[] names, String[] imageUrls, String[] category,
			String[] labels, Double[] prices, String[] description);

	public OmnicelData getSingleRecord(int id);

	public void insertSingleRecord(int id);

	public void insertSingleRecord(OmnicelData data);
}
