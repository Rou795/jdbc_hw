package hw.netology.JDBC_homework;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class JdbcHomeworkApplication implements CommandLineRunner {

	private final DataSource dataSource;

	private final JdbcTemplate jdbcTemplate;

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public JdbcHomeworkApplication(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.dataSource = dataSource;
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(JdbcHomeworkApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Transactional
	@Override
	public void run(String... args) throws SQLException {
		dataSource.getConnection();
	}
}

