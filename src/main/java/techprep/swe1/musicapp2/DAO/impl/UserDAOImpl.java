package techprep.swe1.musicapp2.DAO.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import techprep.swe1.musicapp2.DAO.userDAO;

public class UserDAOImpl implements userDAO {
    private JdbcTemplate jdbcTemplate;
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
