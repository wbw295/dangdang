package org.tarena.dang.action.main;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.Book;
import org.tarena.dang.entity.Category;
import org.tarena.dang.util.Factory;

public class BookListAction extends BaseAction {
	//input
	private int pid;//父类id
	private int cid;//子类id
	private int page=1;//显示第几页，默认时第一页
	//output
	private List<Category> cats;//跟pid获得的子类
	private int totalNum;//全部数量
	private int totalPage;//总页数
	private List<Book> books;//中间产品列表信息
	//injection
	private int pageSize=3;//每页显示3条
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//根据pid，查询cats数据(左侧类别显示)
		CategoryDAO catDao = (CategoryDAO) Factory.getInstance(
				"CategoryDAO");
		cats = catDao.findByParentId(pid);
		//统计全部数量
		for(Category cat:cats){
			if(cat.getId()==cid){
				//统计页数
				totalPage=cat.getPnum()/pageSize;
				if(cat.getPnum()%pageSize!=0){
					totalPage++;
				}
			}
			totalNum+=cat.getPnum();
		}
		
		//根据cid获取books集合(中间产品显示)
		ProductDAO proDao = (ProductDAO) Factory.getInstance(
				"ProductDAO");
		books = proDao.findBooksByCatId(cid,page,pageSize);
		request.setAttribute("totalPage", totalPage);
		return super.execute();
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<Category> getCats() {
		return cats;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

}
