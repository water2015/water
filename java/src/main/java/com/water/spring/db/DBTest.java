package com.water.spring.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/water/spring/db/db.xml")
@Component
public class DBTest {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	private Node root = new Node(1, "Total Citi [L1]", "MAN_SEG_VALUE_LVL_1", "MAN_SEG_DESC_LVL_1");

	private static final String sql = "select distinct REPORTING_PERIOD,MAN_SEG_VALUE_LVL_15,MAN_SEG_DESC_LVL_15,MAN_SEG_VALUE_LVL_14,MAN_SEG_DESC_LVL_14"
			+ ",MAN_SEG_VALUE_LVL_13,MAN_SEG_DESC_LVL_13,MAN_SEG_VALUE_LVL_12,MAN_SEG_DESC_LVL_12,MAN_SEG_VALUE_LVL_11,MAN_SEG_DESC_LVL_11,MAN_SEG_VALUE_LVL_10"
			+ ",MAN_SEG_DESC_LVL_10,MAN_SEG_VALUE_LVL_9,MAN_SEG_DESC_LVL_9,MAN_SEG_VALUE_LVL_8,MAN_SEG_DESC_LVL_8,MAN_SEG_VALUE_LVL_7,MAN_SEG_DESC_LVL_7"
			+ ",MAN_SEG_VALUE_LVL_6,MAN_SEG_DESC_LVL_6,MAN_SEG_VALUE_LVL_5,MAN_SEG_DESC_LVL_5,MAN_SEG_VALUE_LVL_4,MAN_SEG_DESC_LVL_4,MAN_SEG_VALUE_LVL_3"
			+ ",MAN_SEG_DESC_LVL_3,MAN_SEG_VALUE_LVL_2,MAN_SEG_DESC_LVL_2,MAN_SEG_VALUE_LVL_1,MAN_SEG_DESC_LVL_1 "
			+ "from cm_craft where reporting_period=201511";

	@Test
	public void client() {
		jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int idx) throws SQLException {
				Node currentNode = root;

				for (int i = 2; i <= 15; i++) {
					if(String.valueOf(rs.getObject("MAN_SEG_VALUE_LVL_" + i)).equals("test")) {
						System.out.println("i="+i);
						continue;
					}
					int id = rs.getObject("MAN_SEG_VALUE_LVL_" + i) == null ? 0 : Integer.parseInt(String.valueOf(rs.getObject("MAN_SEG_VALUE_LVL_" + i)));
					String name = rs.getString("MAN_SEG_DESC_LVL_" + i);
					if (id != 0 && name != null) {
						Node node = new Node(id, name, "MAN_SEG_VALUE_LVL_" + i, "MAN_SEG_DESC_LVL_" + i);
						currentNode = this.findNode(currentNode, node);
					}
				}

				return null;
			}

			public Node findNode(Node root, Node node) {
				if (root.equals(node)) {
					return root;
				}
				if (!root.childs.contains(node)) {
					root.childs.add(node);
					return node;
				} else {
					return root.childs.get(root.childs.indexOf(node));
				}
			}
		});
		jdbcTemplate.execute("truncate table cm_ms_hier_mappping");
		this.print(root, new Object[33]);
		if(k %1000 != 0) {
			jdbcTemplate.batchUpdate(sql2, batchArgs);
			System.out.println("process : " + k);
		}
	}

	List<Object[]> batchArgs = new ArrayList<Object[]>();
	String sql2 = "insert into cm_ms_hier_mappping(MAN_SEG_VALUE_LVL_1,MAN_SEG_DESC_LVL_1,MAN_SEG_VALUE_LVL_2,MAN_SEG_DESC_LVL_2,MAN_SEG_VALUE_LVL_3,MAN_SEG_DESC_LVL_3,MAN_SEG_VALUE_LVL_4,MAN_SEG_DESC_LVL_4,MAN_SEG_VALUE_LVL_5,MAN_SEG_DESC_LVL_5,MAN_SEG_VALUE_LVL_6,MAN_SEG_DESC_LVL_6,MAN_SEG_VALUE_LVL_7,MAN_SEG_DESC_LVL_7,MAN_SEG_VALUE_LVL_8,MAN_SEG_DESC_LVL_8,MAN_SEG_VALUE_LVL_9,MAN_SEG_DESC_LVL_9,MAN_SEG_VALUE_LVL_10,MAN_SEG_DESC_LVL_10,MAN_SEG_VALUE_LVL_11,MAN_SEG_DESC_LVL_11,MAN_SEG_VALUE_LVL_12,MAN_SEG_DESC_LVL_12,MAN_SEG_VALUE_LVL_13,MAN_SEG_DESC_LVL_13,MAN_SEG_VALUE_LVL_14,MAN_SEG_DESC_LVL_14,MAN_SEG_VALUE_LVL_15,MAN_SEG_DESC_LVL_15,TERMINAL_MS_CODE,TERMINAL_MS_NODE,REPORTING_PERIOD) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	List<String> sqls = new ArrayList<String>();

	int k = 0;

	public void print(Node root, Object[] objs) {
		batchArgs.add(objs);
		int i = Integer.parseInt(root.getIdName().split("_")[4]) - 1;
		objs[i * 2] = root.getId();
		objs[i * 2 + 1] = root.getName();
		
		objs[32] = 201502;
		objs[31] = root.getName();
		objs[30] = root.getId();

		if (++k %1000 == 0) {
			jdbcTemplate.batchUpdate(sql2, batchArgs);
			System.out.println("process : " + k);
			batchArgs.clear();
		}

		if (root.childs.size() > 0) {
			for (Node node : root.childs) {
				this.print(node, objs.clone());
			}
		} 
	}
}
