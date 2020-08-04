package fr.afpa.exercices.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.afpa.exercices.model.Books;
import lombok.extern.log4j.Log4j;

@Repository 
@Log4j
public class BooksDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Books> getAllBooks() {
		String query = "Select * from books";
		return jdbcTemplate.query(query, new BooksMapper());
	}

	private static final class BooksMapper implements RowMapper<Books> {
		public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
			Books bk = new Books();
			bk.setId(rs.getInt("id"));
			bk.setAuthorId(rs.getInt("authorId"));
			bk.setTitle(rs.getString("title"));
			return bk;
		}
	}

	/**
	 * nombre commentairs
	 * 
	 * @return
	 */
	public int getNbBooks() {
		String query = "Select count(*) from Books ";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}

	public List<Books> affauthor() {
		String query = "SELECT * FROM Books WHERE authorId = 5 ";
		return jdbcTemplate.query(query, new BooksMapper());
	}

	public void SupprLivre() {
		String query = "DELETE FROM books WHERE authorId =\"Honore de Balzac\" ";
		jdbcTemplate.update(query);

	}

	public void addauthor(String authorId) {
		String query = "INSERT INTO Books (authorId) values (Sabri Louatah)";
		jdbcTemplate.update(query,authorId);

	}
	
	public void addBooks(int id) {
		 String query= "delete from Books where id = ?";
		 jdbcTemplate.update(query, id);
	}
	
	public void deleCommentByEmail(String email) {
		 String query= "delete from Books where email = ?";
		 jdbcTemplate.update(query, email);
	}
	


}
