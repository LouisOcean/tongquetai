package com.lovo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lovo.entity.Department;
import com.lovo.entity.Ditch;
import com.lovo.entity.Elient;
import com.lovo.entity.Menu;
import com.lovo.entity.Product;
import com.lovo.entity.Record;
import com.lovo.entity.Role;
import com.lovo.entity.UserInfo;
import com.lovo.servers.impl.DepartmentImp;
import com.lovo.servers.impl.DitchImp;
import com.lovo.servers.impl.ElientImp;
import com.lovo.servers.impl.MenuImp;
import com.lovo.servers.impl.ProductImp;
import com.lovo.servers.impl.RecordImp;
import com.lovo.servers.impl.RoleImp;
import com.lovo.servers.impl.UserInfoImp;
import com.lovo.servers.inter.DepartmentInt;
import com.lovo.servers.inter.DitchInt;
import com.lovo.servers.inter.ElientInt;
import com.lovo.servers.inter.MenuInt;
import com.lovo.servers.inter.ProductInt;
import com.lovo.servers.inter.RecordInt;
import com.lovo.servers.inter.RoleInt;
import com.lovo.servers.inter.UserInfoInt;

@SuppressWarnings("serial")
public class DisposeServlet extends HttpServlet {
	private MenuInt mb = new MenuImp();
	private UserInfoInt ub = new UserInfoImp();
	private UserInfo user = new UserInfo();
	private Ditch ditch = new Ditch();
	private DitchInt db = new DitchImp();
	private Department dept = new Department();
	private Product product = new Product();
	private ProductInt pb = new ProductImp();
	private DepartmentInt dtbean = new DepartmentImp();
	private Role role = new Role();
	private RoleInt rolebean = new RoleImp();
	private Menu m = new Menu();
	private Elient elient = new Elient();
	private ElientInt eb = new ElientImp();
	private Record record = new Record();
	private RecordInt rb = new RecordImp();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
			//用户登录
		if (m.equals("login")) {
			login(request, response);
		} else if (m.equals("checkUser")) {
			// 显示用户表所有有效信息
			checkUser(request, response);
		} else if (m.equals("addUser")) {
			// 增加用户
			addUser(request, response);
		} else if (m.equals("delectUser")) {
			// 假删除用户
			delectUser(request, response);
		} else if (m.equals("backfill")) {
			// 回填用户信息
			backfill(request, response);
		} else if (m.equals("modifyUser")) {
			// 修改用户信息
			modifyUser(request, response);
		} else if (m.equals("showDitch")) {
			// 展示渠道信息
			showDitch(request, response);
		} else if (m.equals("addDitch")) {
			// 添加渠道信息
			addDitch(request, response);
		} else if (m.equals("delecteDitch")) {
			// 删除渠道信息
			delecteDitch(request, response);
		} else if (m.equals("showDept")) {
			// 显示所有部门
			showDept(request, response);
		} else if (m.equals("selectMange")) {
			// 查出所有用户信息响应到前台生成下拉列表
			selectMange(request, response);
		} else if (m.equals("addDept")) {
			// 添加部门
			addDept(request, response);
		} else if (m.equals("showProduct")) {
			// 显示产品
			showProduct(request, response);
		} else if (m.equals("addProduct")) {
			// 添加产品
			addProduct(request, response);
		} else if (m.equals("deleteProduct")) {
			// 删除产品
			deleteProduct(request, response);
		} else if (m.equals("backfillProduct")) {
			// 回填产品信息
			backfillProduct(request, response);
		} else if (m.equals("modifyProduct")) {
			// 修改产品信息
			modifyProduct(request, response);
		} else if (m.equals("showRole")) {
			// 显示所有角色
			showRole(request, response);
		} else if (m.equals("selectMenu")) {
			// 查询角色拥有的菜单
			selectMenu(request, response);
		} else if (m.equals("showMenu")) {
			// 展示角色拥有的菜单
			showMenu(request, response);
		} else if (m.equals("queryMenuParent")) {
			// 查询父类菜单
			queryMenuParent(request, response);
		} else if (m.equals("addMenu")) {
			// 添加角色菜单
			addMenu(request, response);
		} else if (m.equals("deleteMenu")) {
			// 删除菜单
			deleteMenu(request, response);
		} else if (m.equals("showElient")) {
			// 展示顾客信息
			showElient(request, response);
		} else if (m.equals("addElient")) {
			// 添加顾客信息
			addElient(request, response);
		} else if (m.equals("selectElient")) {
			// 查询顾客信息
			selectElient(request, response);
		} else if (m.equals("delectElient")) {
			// 假删除顾客信息
			delectElient(request, response);
		} else if (m.equals("selectDitch")) {
			// 查询渠道 用在添加客户页面动态添加option
			selectDitch(request, response);
		} else if (m.equals("selectProduct")) {
			// 查询产品 用在添加客户页面动态添加option
			selectProduct(request, response);
		} else if (m.equals("selectUser")) {
			// 查询咨询师 用在添加客户页面动态添加option
			selectUser(request, response);
		} else if (m.equals("selectCounselor")) {
			// 查询咨询师 用在添加跟踪记录页面上
			selectCounselor(request, response);
		} else if (m.equals("showRecord")) {
			// 显示所有跟踪记录
			showRecord(request, response);
		} else if (m.equals("addReeord")) {
			// 添加跟踪记录
			addRecord(request, response);
		} else if (m.equals("deleteRecord")) {
			// 删除跟踪记录
			deleteRecord(request, response);
		} else if (m.equals("backfillRecord")) {
			// 回填跟踪记录
			backfillRecord(request, response);
		} else if (m.equals("modifyRecord")) {
			// 修改跟踪记录
			modifyRecord(request, response);
		}
	}
	/**
	 * 登录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String userPasw = req.getParameter("userPasw");
		boolean b = ub.userJudgeLogin(userName, userPasw);
		if (b) {
			// 调用queryUserName方法、根据用户名查询用户信息
			user = ub.queryUserName(userName);
			// 设置Sessison对象
			req.getSession().setAttribute("user", user);
			
			List<Menu> list = mb.queryMenu(user.getRole_id());
			req.setAttribute("list", list);
			req.getRequestDispatcher("view/index.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("view/login.jsp").forward(req, resp);
		}

	}

	/**
	 * 将查出来的uesrInfo对象数据返回到页面上
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		String sql = request.getParameter("sql");
		if (sql == null) {
			sql = "";
		}
		int total = ub.selectUserInfo(user).size();
		List<UserInfo> list = ub.showUserInfo(user, pageNumber, pageSize, sql);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		response.getWriter().write(JSONObject.fromObject(map).toString());
	}

	/**
	 * 增加用户
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int job = Integer.parseInt(req.getParameter("job"));
		String userName = req.getParameter("userName");
		String userPasw = req.getParameter("userPasw");
		String realName = req.getParameter("realName");
		String tel = req.getParameter("tel");
		String userHead = req.getParameter("head");
		String email = req.getParameter("email");
		String QQ = req.getParameter("qq");
		String weChat = req.getParameter("weChat");
		String urgency_name = req.getParameter("urgency_name");
		String urgency_tel = req.getParameter("urgency_tel");
		int department_id = Integer.parseInt(req.getParameter("department_id"));
		String hiredate = req.getParameter("hiredate");
		String dataState = req.getParameter("dataState");
		int role_id = Integer.parseInt(req.getParameter("role_id"));
		UserInfo userInfo = new UserInfo(job, userName, userPasw, realName,
				tel, userHead, email, QQ, weChat, urgency_name, urgency_tel,
				department_id, hiredate, dataState, role_id);

		ub.addUser(userInfo);

	}

	/**
	 * 删除用户
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delectUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int u_id = Integer.parseInt(req.getParameter("ids"));
		ub.delectUser(u_id);
	}

	/**
	 * 用户修改表单回填数据的查询
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void backfill(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		UserInfo user = ub.getUserById(id);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(user).toString());

	}

	/**
	 * 取得前台用户填写的修改信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifyUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		int job = Integer.parseInt(req.getParameter("job"));
		String userName = req.getParameter("userName");
		String userPasw = req.getParameter("userPasw");
		String realName = req.getParameter("realName");
		String tel = req.getParameter("tel");
		String userHead = req.getParameter("head");
		String email = req.getParameter("email");
		String QQ = req.getParameter("qq");
		String weChat = req.getParameter("weChat");
		String urgency_name = req.getParameter("urgency_name");
		String urgency_tel = req.getParameter("urgency_tel");
		int department_id = Integer.parseInt(req.getParameter("department_id"));
		String hiredate = req.getParameter("hiredate");
		String dataState = req.getParameter("dataState");
		int role_id = Integer.parseInt(req.getParameter("role_id"));
		UserInfo userInfo = new UserInfo(u_id, job, userName, userPasw,
				realName, tel, userHead, email, QQ, weChat, urgency_name,
				urgency_tel, department_id, hiredate, dataState, role_id);

		ub.queryUserID(userInfo);

	}

	/**
	 * 分页显示 将查出来的渠道信息响应到页面上
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showDitch(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		List<Ditch> list = db.showDitch(ditch, pageNumber, pageSize);
		int total = db.checkDitch(ditch).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		resp.getWriter().write(JSONObject.fromObject(map).toString());

	}

	/**
	 * 增加渠道信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addDitch(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ditchInfo = req.getParameter("ditchInfo");
		String ditchName = req.getParameter("ditchName");
		int cost = Integer.parseInt(req.getParameter("cost"));
		String beginTime = req.getParameter("beginTime");
		String ditchState = req.getParameter("ditchState");
		ditch = new Ditch(ditchInfo, ditchName, cost, beginTime, ditchState);
		db.addDitch(ditch);

	}

	/**
	 * 删除渠道信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delecteDitch(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("ids"));
		db.delecteDitch(id);
	}

	/**
	 * 显示部门所有信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showDept(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取分页信息
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		// 查询总条目数
		int total = dtbean.showDept(dept).size();
		// 查询每页信息
		List<Department> list = dtbean.showDeptOnPage(dept, pageNumber,
				pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		resp.getWriter().write(JSONObject.fromObject(map).toString());

	}

	/**
	 * 查出所有用户信息响应到前台生成下拉列表 选取主管
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectMange(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<UserInfo> list = ub.selectUserInfo(user);
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

	/**
	 * 添加部门
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addDept(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String d_name = req.getParameter("d_name");
		int manage_id = Integer.parseInt(req.getParameter("manage_id"));
		String d_describe = req.getParameter("d_describe");
		String deptState = req.getParameter("deptState");
		Department deptp = new Department(d_name, manage_id, d_describe,
				deptState);
		dtbean.addDemp(deptp);

	}

	/**
	 * 显示所有有效产品
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		int total = pb.showProduct(product).size();
		List<Product> list = pb.showAllProduct(product, pageNumber, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}

	/**
	 * 添加产品
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String p_name = req.getParameter("p_name");
		// 推荐医生
		String recommendDoctor = req.getParameter("recommendDoctor");
		String p_describe = req.getParameter("p_describe");// 产品描述
		String createTime = req.getParameter("createTime");
		String p_state = req.getParameter("p_state");// 产品是否有效
		product = new Product(p_name, recommendDoctor, p_describe, createTime,
				p_state);
		pb.addProduct(product);
	}

	/**
	 * 删除产品(假删除);
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int p_id = Integer.parseInt(req.getParameter("ids"));
		pb.delectProduct(p_id);

	}

	/**
	 * 回填产品信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void backfillProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int p_id = Integer.parseInt(req.getParameter("p_id"));
		Product product = pb.backfillProduct(p_id);
		resp.getWriter().write(JSONObject.fromObject(product).toString());
	}

	/**
	 * 修改产品
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifyProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int p_id = Integer.parseInt(req.getParameter("p_id"));
		String p_name = req.getParameter("p_name");
		String recommendDoctor = req.getParameter("recommendDoctor");// 推荐医生
		String p_describe = req.getParameter("p_describe");
		String createTime = req.getParameter("createTime");
		String p_state = req.getParameter("p_state");
		product = new Product(p_id, p_name, recommendDoctor, p_describe,
				createTime, p_state);
		pb.modifyProduct(product);

	}

	/**
	 * 显示所有角色信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showRole(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		int total = rolebean.showRole(role).size();
		List<Role> list = rolebean.pageShowRole(role, pageNumber, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		resp.getWriter().write(JSONObject.fromObject(map).toString());

	}

	/**
	 * 根据id查询所拥有的菜单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		List<Menu> list = rolebean.queryMenu(id);
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

	/**
	 * 显示所有菜单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		int total = mb.showMenu(m).size();
		List<Menu> list = mb.pageShowMenu(m, pageNumber, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}

	/**
	 * 查询一级菜单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryMenuParent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Menu> list = mb.queryMenuParent();
		resp.getWriter().write(JSONArray.fromObject(list).toString());

	}

	/**
	 * 添加菜单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String m_name = req.getParameter("m_name");
		String url = req.getParameter("url");
		int parent_id = Integer.parseInt(req.getParameter("parent_id"));
		m = new Menu(m_name, url, parent_id);
		mb.addMenu(m);

	}

	/**
	 * 删除菜单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("ids"));
		mb.deleteMenu(id);

	}

	/**
	 * 显示所有客户信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showElient(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		String sql = req.getParameter("sql");
		if (sql == null) {
			sql = "";
		}
		System.out.println(sql);
		int total = eb.showCleint(elient).size();
		List<Elient> list = eb.pageshowCleint(elient, pageNumber, pageSize, sql);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}

	/**
	 * 添加客户
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addElient(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int manke = Integer.parseInt(req.getParameter("manke"));
		String e_name = req.getParameter("e_name");
		String e_sex = req.getParameter("e_sex");
		String e_tel = req.getParameter("e_tel");
		String e_source = req.getParameter("e_source");// 来源渠道
		String QQ = req.getParameter("QQ");
		String consultProduct = req.getParameter("consultProduct");// 咨询产品
		String counselor = req.getParameter("counselor");// 质询师
		String turnover = req.getParameter("turnover");// 首次成交金额
		String totalMoney = req.getParameter("totalMoney");// 总金额
		String detailedAddress = req.getParameter("detailedAddress");// 详细地址
		System.out.println(detailedAddress);
		String arrivalDate = req.getParameter("arrivalDate");// 预计到店时间
		String revisitDays = req.getParameter("revisitDays");// 预计回访时间
		String data = req.getParameter("data");
		elient = new Elient(manke, e_name, e_sex, e_tel, e_source, QQ,
				consultProduct, counselor, turnover, totalMoney,
				detailedAddress, arrivalDate, revisitDays, data);
		elient.addElient(elient);
	}
	/**
	 * 删除客户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delectElient(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("ids"));
		elient.delectElient(id);
	}
	

	/**
	 * 查询客户信息 用在动态添加纪录上的option
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectElient(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		List<Elient> list = eb.showCleint(elient);
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

	/**
	 * 查询渠道信息、、用到添加客户页面动态添加option节点
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectDitch(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Ditch> list = db.checkDitch(ditch);
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

	/**
	 * 查询产品信息动态添加到增加客户页面option
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Product> list = pb.showProduct(product);
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

	/**
	 * 查询咨询师
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<UserInfo> list = ub.selectUserInfo(user);
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}



	/**
	 * 查询质询师 用在动态添加纪录上的option
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectCounselor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<UserInfo> list = rb.selectCounselor(user);
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

	/**
	 * 分页显示所有跟踪记录
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showRecord(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		int total = rb.showRecord(record).size();
		List<Record> list = rb.showPageRecord(record, pageNumber, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}
	/**
	 * 添加跟踪记录
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addRecord(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		int elient_id = Integer.parseInt(req.getParameter("elient_id"));
		String progress = req.getParameter("progress");
		String progressInfo = req.getParameter("progressInfo");
		String trackingDate = req.getParameter("trackingDate");
		String returnDate = req.getParameter("returnDate");
		Record record = new Record(user_id, elient_id, progress, progressInfo,
				trackingDate, returnDate);
		rb.addRecord(record);

	}

	/**
	 * 删除跟踪记录
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteRecord(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		rb.deleteRecord(id);
	}

	/**
	 * 回填跟踪记录
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void backfillRecord(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Record record = rb.backfillRecord(id);
		resp.getWriter().write(JSONObject.fromObject(record).toString());
	}

	/**
	 * 修改跟踪记录
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifyRecord(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		int elient_id = Integer.parseInt(req.getParameter("elient_id"));
		String Mprogress = req.getParameter("Mprogress");
		String progressInfo = req.getParameter("progressInfo");
		String trackingDate = req.getParameter("trackingDate");
		String returnDate = req.getParameter("returnDate");
		record = new Record(id, user_id, elient_id, Mprogress, progressInfo,
				trackingDate, returnDate);
		rb.modifyRecord(record);
	}

}
