package persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import abstraction.IOmnicelDAO;
import datas.OmnicelData;

@Repository
public class OmincelDAO implements IOmnicelDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Integer getAllRecords() {
		System.out.println("get all records");
		String sql = "SELECT COUNT(*) FROM OMNICEL";
		return jdbcTemplate.queryForObject(sql, Integer.class);		
	}

	@Override
	public void insertRecordsFirstTime(Integer[] ids, String[] names, String[] imageUrls, String[] category,
			String[] labels, Double[] prices, String[] description) {
		
		String sql = "INSERT INTO OMNICEL (ID, NAME, IMAGE_URL, CATEGORY, LABELS, PRICES, DESCRIPTION) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int insertedRows = 0;
		for(int i=0; i<9; i++) {
			insertedRows += jdbcTemplate.update(sql, ids[i], names[i], imageUrls[i], category[i], labels[i], prices[i], description[i]);
		}		
		System.out.println("inserted records >> "+insertedRows);
	}

	@SuppressWarnings("deprecation")
	@Override
	public OmnicelData getSingleRecord(int id) {
		String query = "SELECT * FROM OMNICEL WHERE ID = ?";
		return (OmnicelData) jdbcTemplate.queryForObject(query, new Object[] {id}, new BeanPropertyRowMapper<>(OmnicelData.class));
	}

	@Override
	public void insertSingleRecord(int id) {
		// TODO Auto-generated method stub
		System.out.println("insrted >> "+id);
		String sql = "INSERT INTO OMNICEL (ID, NAME, IMAGE_URL, CATEGORY, LABELS, PRICES, DESCRIPTION) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int val = jdbcTemplate.update(sql, id, "sj", "https://stackoverflow.com/users/8359623/papai-from-bekoail", "hot", "deo", 4.4, "demo");
		System.out.println("value insrted :: "+val);
	}

	@Override
	public void insertSingleRecord(OmnicelData data) {
		String sql = "INSERT INTO OMNICEL (ID, NAME, IMAGE_URL, CATEGORY, LABELS, PRICES, DESCRIPTION) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int val= jdbcTemplate.update(sql, data.getId(), data.getName(), data.getImageUrl(), data.getCategory(), 
				                 data.getLabel(), data.getPrice(), data.getDescription());
		
		if(val != 0) {
			System.out.println("value inserted successfully");
		}
		
	}
	
	
}
