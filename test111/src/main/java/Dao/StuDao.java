package Dao;

import entity.Stu;

import java.util.List;

public interface StuDao {
	/** 
	 * Inserts a new row in the books table.
	 * 插入一本书
	 */
	public int insert(Stu stu) ;

	/** 
	 * Updates a single row in the books table.
	 * 修改一本书
	 */
	public int update( Stu stu) ;

	/** 
	 * Deletes a single row in the books table.
	 * 删除一本书
	 */
	public int delete(int id) ;

	/** 
	 * Returns all rows from the books table that match the criteria 'and isbn = ?'.
	 * 根据ISBN查找一本书
	 */
	public Stu findByPrimaryKey(String id) ;
	/** 
	 * Returns all rows from the books table that match the criteria 'and bookname = ? and publisherID = ?'.
	 */
	public List<Stu> findByName_Sex(String name, String sex) ;
	/**
	 * Returns all rows from the books table that match the criteria 'and bookname = ? '.
	 */
	public List<Stu> findByName(String bookname) ;
	/**
	 * Returns all rows from the books table that match the criteria 'and publisherID = ?'.
	 */
	public List<Stu> findByID(int id) ;

	/**
	 * Returns all rows from the books table that match the criteria ''.
	 * 查找所有书
	 */
	public List<Stu> findAll() ;
	/**
	 *
	 * @param sql
	 * @param sqlParams
	 * @return
	 */

	public List<Stu> findByDynamicWhere(String sql, String[] sqlParams);
	/**
	 * 修改图书库存量
	 * @param book
	 * @return
	 */

	public int updateCount(Stu stu) ;
}
