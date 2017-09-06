package org.lanqiao.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;
import org.lanqiao.util.DbUtil;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class UserDaoImpl implements UserDao {
	@Override
	public List<User> list() {
		List<User> list = new ArrayList<User>();
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("uuid"), rs.getString("uname"), rs.getString("ujob"),
						rs.getString("unick"), rs.getString("uemail"), rs.getDate("udate"),rs.getString("umessage"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally{
			try {
				if(rs!=null) rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	/**
	 * 
	 */
	@Override
	public void add(User user) {
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUuid());
			ps.setString(2, user.getUname());
			ps.setString(3, user.getUjob());
			ps.setString(4, user.getUnick());
			ps.setString(5, user.getUemail());
			ps.setDate(6, user.getUdate());
			ps.setString(7, user.getUmessage());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void delete(String uuid) {
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from users where uuid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(User user) {
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update users set uname=?,ujob=?,unick=?,uemail=?,udate=?,umessage=? where uuid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUjob());
			ps.setString(3, user.getUnick());
			ps.setString(4, user.getUemail());
			ps.setDate(5, user.getUdate());
			ps.setString(6, user.getUmessage());
			ps.setString(7, user.getUuid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public User search(String keyword) {
		User user =null;
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users where uuid=? or uname=? or ujob=? or unick=? or uemail=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setString(2, keyword);
			ps.setString(3, keyword);
			ps.setString(4, keyword);
			ps.setString(5, keyword);
			rs = ps.executeQuery();
			if(rs.next())
			user = new User(rs.getString("uuid"), rs.getString("uname"), rs.getString("ujob"),
					rs.getString("unick"), rs.getString("uemail"), rs.getDate("udate"),rs.getString("umessage"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	@Override
	public void exports(String url) {
		File file = new File(url);
		try {
			WritableWorkbook wb = Workbook.createWorkbook(file);
			WritableSheet sheet = wb.createSheet("联系人表", 0);
			WritableCellFormat format = new WritableCellFormat();
			format.setAlignment(jxl.format.Alignment.CENTRE);
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			List<User> users = this.list();
			Label[] lab = new Label[6];
			lab[0] = new Label(0, 0, "姓名",format);
			lab[1] = new Label(1, 0, "职业",format);
			lab[2] = new Label(2, 0, "昵称",format);
			lab[3] = new Label(3, 0, "邮箱",format);
			lab[4] = new Label(4, 0, "日期",format);
			lab[5] = new Label(5, 0, "信息",format);
			for (int i = 0; i < lab.length; i++) {
				sheet.addCell(lab[i]);
				sheet.setColumnView(i, 30);
			}
			List<Label> labelList = new ArrayList<Label>();
			for (int i = 1; i <= users.size(); i++) {
				labelList.add(new Label(0,i,users.get(i-1).getUname(),format));
				labelList.add(new Label(1,i,users.get(i-1).getUjob(),format));
				labelList.add(new Label(2,i,users.get(i-1).getUnick(),format));
				labelList.add(new Label(3,i,users.get(i-1).getUemail(),format));
				labelList.add(new Label(4,i,users.get(i-1).getUdate().toString(),format));
				labelList.add(new Label(5,i,users.get(i-1).getUmessage(),format));
 			}
			for (int i = 0; i < labelList.size(); i++) {
				sheet.addCell(labelList.get(i));
			}
			for (int j = 0; j < sheet.getRows(); j++) {
				sheet.setRowView(j, 500);
			}
			wb.write();
			wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void imports(String url) {
		File file = new File(url);
		if(!file.exists())return;
		try {
			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(0);
			for (int i = 1; i < sheet.getRows(); i++) {
				String uuid = UUID.randomUUID().toString();
				String uname = sheet.getCell(0,i).getContents();
				String ujob = sheet.getCell(1,i).getContents();
				String unick = sheet.getCell(2,i).getContents();
				String uemail = sheet.getCell(3,i).getContents();
				String udate = sheet.getCell(4, i).getContents();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate;
				try {
					utilDate = format.parse(udate);
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					String umessage = sheet.getCell(5, i).getContents();
					User user = new User(uuid,uname,ujob,unick,uemail,sqlDate,umessage);
					this.add(user);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

}
