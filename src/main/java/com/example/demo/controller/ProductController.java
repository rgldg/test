package com.example.demo.controller;


import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDis;
import com.example.demo.entity.ProductNew;
import com.example.demo.entity.ProductRec;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductDisService;
import com.example.demo.service.ProductNewService;
import com.example.demo.service.ProductRecService;
import com.example.demo.service.ProductService;
import com.example.demo.util.UploadUtil;


@Controller
@RequestMapping("/*")
public class ProductController {
	

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductNewService productNewService;
	@Autowired
	ProductRecService productRecService;
	@Autowired 
	ProductDisService productDisService;
	
	String localpath="D:/photo/";
	/*
	 * 商品添加
	 *@param photo 要上传图片 
	 */
	@Transactional
	@RequestMapping("doproductadd")
	public String productAdd(@RequestParam("photoname")MultipartFile photo,HttpServletRequest request,Product product,HttpSession session){
		Category category=new Category();
		String name=request.getParameter("name");//获取商品名称
		Integer csid=Integer.parseInt(request.getParameter("categoryId"));//获取类目id
		category.setId(csid);
		System.out.println("********"+category+"***********");
		Integer stock=Integer.parseInt(request.getParameter("stock"));//获取商品库存
		Float price=Float.parseFloat(request.getParameter("price"));//获取商品价格
		String description=request.getParameter("description");//获取商品描述
		Product product1=new Product();
		if (photo.isEmpty()) {
			return "productshow";
		}
		//拿到文件名
		String filename=photo.getOriginalFilename();
		//存放上传图片的文件夹
		File fileDir=UploadUtil.getImgDirFile();
		System.out.println(fileDir.getAbsolutePath());//输出文件夹绝对路径--相对于当前项目的路径
		try {
			//构建真实的文件路径
			File newFile=new File(fileDir.getAbsolutePath() + File.separator + filename);
            System.out.println(newFile.getAbsolutePath());
            //上传图片到“绝对路径”
            photo.transferTo(newFile);
            product1.setPath(filename);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		product1.setPath(UploadUtils.fileload(photo, photo.getOriginalFilename(), localpath));//上传返回值，上传工具类调用（图片文件，文件名获取，文件路径）
		product1.setName(name);
		product1.setStock(stock);
		product1.setPrice(price);
		product1.setDescription(description);
		product1.setCategory(category);
		product1.setCount(1);
		product1.setCsid(csid);//category==categoryId
		productService.save(product1);
		return "redirect:/admin";
	}
	@RequestMapping(value= {"toproductshow"})
	public String productShow(HttpSession session) {
		List<Product> productList=productService.findAll();
		session.setAttribute("productList", productList);
		return "productshow";
	}
	
	@Transactional
	@RequestMapping("prodelete")
	public String delete(Integer id) {
		productService.delete(id);
		return "redirect:/toproductshow";
	}
	
	@Transactional
	@RequestMapping(value= {"toEdit"})//action
	public String toEdit(HttpSession session,Map<String, Object> map,Integer id){//,Model model,Map<String, Object> map		
		Product product=productService.findById(id);
		List<Category> categoryList=categoryService.findAll();
		System.out.println("*********Csid"+product.getCsid()+"*********");
		System.out.println("*********categoryid:"+product.getCategory()+"*********");		
//		Category category=categoryService.findById(product.getCsid());
//		product.setCategory(category);
		map.put("product", product);
		session.setAttribute("categoryList", categoryList);
		return "productupdate";//跳转页面
	}
	
	
	@Transactional
	@RequestMapping("proupdate")
	public String update(@RequestParam("photoname")MultipartFile photo,HttpServletRequest request,Product product,HttpSession session,Integer id) throws Exception {
		Category category=new Category();
		String name=request.getParameter("name");//获取商品名称
//		String path=request.getParameter("path");//获取商品地址
//		String pname=request.getParameter("photoname");
//		List<String> img= getImgStr("productupdate.html");//获取img的src地址
//		String imgString=String.join("",img);
//		System.out.println("******imgString:"+getImgStr("productupdate")+"*******");
//		System.out.println("******img:"+img+"*******");
		Integer csid=Integer.parseInt(request.getParameter("categoryId"));//获取类目id
		Integer count=Integer.parseInt(request.getParameter("count"));//获取点击数
		category.setId(csid);
		System.out.println("********"+category+"***********");
		Integer stock=Integer.parseInt(request.getParameter("stock"));//获取商品库存
		Float price=Float.parseFloat(request.getParameter("price"));//获取商品价格
		String description=request.getParameter("description");//获取商品描述		
		Product product2 = productService.findById(id);//获取商品id
		Integer count2 = 1;
		if(count!=1) {
			count2=count;
			}
		else {
			count=count2;
		}
		//上传返回值,返回文件名，上传工具类调用（图片文件，文件名获取，文件路径）	
//		String imgUrl=UploadUtils.fileload(photo, photo.getOriginalFilename(), localpath);
//		
//		if (StringUtils.isNotBlank(imgUrl)) {
////			product2.setPath(imgString);
//			product2.setPath(imgUrl);		
//		}
		if (photo.isEmpty()) {
			return "productshow";
		}
		//拿到文件名
		String filename=photo.getOriginalFilename();
		//存放上传图片的文件夹
		File fileDir=UploadUtil.getImgDirFile();
		System.out.println(fileDir.getAbsolutePath());//输出文件夹绝对路径--相对于当前项目的路径
		try {
			//构建真实的文件路径
			File newFile=new File(fileDir.getAbsolutePath() + File.separator + filename);
            System.out.println(newFile.getAbsolutePath());
            //上传图片到“绝对路径”
            photo.transferTo(newFile);
            product2.setPath(filename);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		product2.setName(name);
		product2.setStock(stock);
		product2.setPrice(price);
		product2.setDescription(description);
		product2.setCategory(category);
		product2.setCount(count2);
		
		product2.setCsid(csid);//category==categoryId		
//		productService.edit(product2);
		boolean flag = false;
        try {
            productService.edit(product2);
            flag = true;
        } catch (Exception e) {
            throw new Exception(e);
        }
        if (!flag) {
            request.setAttribute("message", "更新失败！");
        }
		return "redirect:/toproductshow";
	}
	
	//新品
	@RequestMapping("toNew")
	public String doDis(HttpServletRequest request,ProductNew productNew,Integer id) {
		Product product=productService.findById(id);
		Integer productId=product.getId();
		java.sql.Timestamp systime = new java.sql.Timestamp(new java.util.Date().getTime());
		ProductNew productNew2=new ProductNew();		
		if (NewProductId(id)==true) {
			productNew2.setProduct(productId);
			productNew2.setSystime(systime);
			productService.saveNew(productNew2);
		}
		return "redirect:/toproductshow";
	}
	public Boolean NewProductId(Integer id) {
		Boolean a=true;
		if(productService.findByProductId(id) == null) {
			return a;
		}else {
			return false;
		}
	}
	
	//推荐
	@RequestMapping("toRec")
	public String doRec(HttpServletRequest request,ProductRec productRec,Integer id) {
		Product product=productService.findById(id);
		Integer productId=product.getId();
		String showtext=product.getDescription();
		ProductRec productRec2=new ProductRec();
		if (RecProductId(id)==true) {
			productRec2.setProduct(productId);
			productRec2.setShowText(showtext);
			productService.saveRec(productRec2);;
		}
		return "redirect:/toproductshow";
	}
	public Boolean RecProductId(Integer id) {
		Boolean a=true;
		if(productService.findByIdRec(id) == null) {
			return a;
		}else {
			return false;
		}
	}
	
	//打折
	@RequestMapping("toDis")
	public String toDis(Map<String, Object> map,Integer id,HttpSession session) {
		Product product=productService.findById(id);
//		List<ProductDis> productDis=productDisService.findAll();//获得打折表所有数据
//		Object[] o=productDis.toArray();
//		Set<Integer> set=new HashSet<>();
//		for (int i = 0; i < o.length; i++) {
//			ProductDis pDis=(ProductDis)o[i];
//			//获得打折表所有商品id
//			if (pDis.getProduct()==id) {//打折表商品id==商品id				
//				ProductDis productList=productService.findByIdDis(pDis.getProduct());			
//				session.setAttribute("productList", productList);
//				break;
//			}
//		}
		map.put("product", product);
		return "writeDis";
	}
	@RequestMapping("doDis")
	public String doDis(HttpServletRequest request,ProductDis productDis,Integer id) {
		Product product=productService.findById(id);
//		Integer productId=product.getId();
		float price=product.getPrice(); 
		Integer discount=Integer.parseInt(request.getParameter("discount"));		
			ProductDis productDis2=new ProductDis();
			if (DisProductId(id)==true) {
			productDis2.setDiscount(discount);
			productDis2.setPrice(price);
			productDis2.setProduct(id);
			productService.saveDis(productDis2);
			}
		return "redirect:/toproductshow";
	}
	public Boolean DisProductId(Integer id) {
		Boolean a=true;
		if(productService.findByIdDis(id) == null) {
			return a;
		}else {
			return false;
		}
	}
	/*
	 * NewShow
	 * 新品列表
	 */
	@RequestMapping("NewShow")
	public String NewShow(HttpSession session) {
		List<ProductNew> list=productNewService.findAll();
		Object[] o=list.toArray();
//		for (int i = 0; i < list.size(); i++) {
//			ProductNew maps=list.get(i);
//			List<Integer> id=maps.getProduct();
//			System.out.println(maps);
			
//		}
//		Integer id1=productService.findByProduct_id(id);
//		List<ProductNew> list=productNewService.findAll();	
//		ProductNew maps=list.get(1);
//		Object[] o=list.toArray();
		Set<Integer> set=new HashSet<>();
//		List<Integer> idList=new ArrayList<Integer>();
		for (int i = 0; i < o.length; i++) {
			ProductNew pNew=(ProductNew)o[i];
			System.out.println("  ****id:"+pNew.getId()+"  ****product_id:"+pNew.getProduct()+"  ****systime:"+pNew.getSystime());			
//			idList.add(pNew.getProduct());
			set.add(pNew.getProduct());
		}
//		maps.getProduct();
//			System.out.println(maps.getProduct());
//		List<Product> productList=productService.findAllById(list);			
//		session.setAttribute("productList", productList);
			
		List<Product> productList=productService.findAllById(set);			
				session.setAttribute("productList", productList);
		return "ProductNew";
	}
	
	
	/*
	 * RecShow
	 * 推荐列表
	 */
	@RequestMapping("RecShow")
	public String RecShow(HttpSession session) {
		List<ProductRec> list=productRecService.findAll();
		Object[] o=list.toArray();
		Set<Integer> set=new HashSet<>();
		for (int i = 0; i < o.length; i++) {
			ProductRec pRec=(ProductRec)o[i];
			System.out.println("  ****id:"+pRec.getId()+"  ****product_id:"+pRec.getProduct()+"  ****showtext:"+pRec.getShowText());			
			set.add(pRec.getProduct());
		}
		List<Product> productList=productService.findAllById(set);			
		session.setAttribute("productList", productList);
		return "ProductRec";
	}
	/*
	 * DisShow
	 * 打折列表
	 */
	@RequestMapping("DisShow")
	public String DisShow(HttpSession session) {
		List<ProductDis> list=productDisService.findAll();
		Object[] o=list.toArray();
		Set<Integer> set=new HashSet<>();
		for (int i = 0; i < o.length; i++) {
			ProductDis pDis=(ProductDis)o[i];
			System.out.println("  ****id:"+pDis.getId()+"  ****product_id:"+pDis.getProduct()+"  ****discount:"+pDis.getDiscount()+"  ****price:"+pDis.getPrice());			
			set.add(pDis.getProduct());
		}
		List<Product> productList=productService.findAllById(set);			
		session.setAttribute("productList", productList);
		return "ProductDis";
	}
}
