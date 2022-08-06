package com.spring.crud;

import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import lombok.extern.log4j.Log4j;

@Controller
public class ArticleController {
	Statement stmt;

	// ���� ����
	@Autowired
	private ArticleService articleService;

	// ������ ��� �޼ҵ�鿡�� request.setAttribute("article", articleService.selectById(vo))��
	// ���ִ� �Ͱ� ���� ����
	@ModelAttribute("article")
	public ArticleVO getArticle() {
		ArticleVO vo = new ArticleVO();
		return articleService.selectById(vo);
	}

	// 1. �Խñ� ��� ����� insrt() �޼��� ����
	@RequestMapping("/article/write.do")
	public String insert(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
		return process(request, response, vo, "insert");
	}

	// 2. �ֱ� �Խñ� ��ȸ ����� selectById() �޼��� ����
	@RequestMapping("/article/read.do")
	public String selectById(ArticleVO vo) {
		return "/WEB-INF/views/readArticle.jsp";
	}

	// 3. �ֱ� �Խñ� ���� ����� update() �޼��� ����
	@RequestMapping("/article/modify.do")
	public String update(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
		return process(request, response, vo, "update");
	}

	// 4. �ֱ� �Խñ� ���� ����� update() �޼��� ����
	@RequestMapping("/article/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
		System.out.println("���� id ����??"+vo.getId());
		System.out.println("���� ���� title����??"+vo.getTitle());
		
		return process(request, response, vo, "delete");
	}

	@RequestMapping("/article/getList.do")
	public String getList(final Model model) {
		List<ArticleVO> list = articleService.getList();
		System.out.println("�ٸ���Ʈ�׽�Ʈ@@@@������aaa�̼�???" + list.get(3).getTitle());
		model.addAttribute("ARTICLE_ID", list);
		return "/WEB-INF/views/getListForm.jsp";
	}

//	@RequestMapping("/article/selectFromList.do")
//	public String selectFromList(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, Model model) {
//		System.out.println("����Ʈ���Ҹ���Ʈ ��� ��������??"+vo.getId());
//		model.addAttribute("ARTICLE_ID", vo);
//		return process(request, response, vo, "selectFromList");
//	}

	// �Խ��ǿ��� �Խñ� �̵� ��ư Ŭ���ϸ� �ش� �Խñ� �󼼺��� �������� �̵�
	// Ű��(id)�� ��ü�� jsp���� get���� param�� �Է¹޾� �̵��ϴ� ���
	@RequestMapping({"/article/selectFromList.do", "/test" })
	public String selectFromList(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, Model model,
			@RequestParam("id") int id) {
		System.out.println("����Ʈ���Ҹ���Ʈ ��� ��������?? ����� id�� : >>>> " + id);

		model.addAttribute("ARTICLE_ID", articleService.selectFromList(vo));
		
//		System.out.println("requestAttribute �� Ȯ�ο� : " + (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
		
		return process(request, response, vo, "selectFromList");
	}
	
	
	
	// selectFromList���� modify��ư �Է� �� ����Ǵ� �޼���
	@RequestMapping({"/article/updateFromList.do" })
	public String updateFromList(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, Model model) {
		System.out.println("����Ʈ���� ������Ʈ�� �̵�����?? ����� id�� : >>>> ");
		System.out.println(vo.getId());
		System.out.println(vo.getTitle());
		
		model.addAttribute("ARTICLE_ID", articleService.selectFromList(vo));
		
		return process(request, response, vo, "updateFromList");
	}
	
	// modifyFromList���� submit ��ư �Է� �� ����Ǵ� �޼���
	@RequestMapping("/article/updateFromListActive.do")
	public String updateFromListSuccess(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, Model model) {
		System.out.println("������Ʈ���Ҹ���Ʈ��Ƽ�갡 ��������??????");
		System.out.println(vo.getId());
		System.out.println(vo.getTitle());

//		model.addAttribute("ARTICLE_ID", articleService.selectFromList(vo));
		return process(request, response, vo, "updateFromListActive");
	}
	
//	// select �信�� delete��ư ���������Ǵ� ���
//	@RequestMapping("/article/deleteFromSelect.do")
//	public String deleteFromSelect(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
//		System.out.println("����Ʈ���Ҽ���Ʈ�� ��������??????????");
//		
//		return process(request, response, vo, "deleteFromSelect");
//	}
//	
	
	// GET, POST, �� ���� ��û���� �б� ó���� ���ִ� �޼��� ����
	private String process(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, String query) {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			return viewResolverForm(query);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			executeQuery(query, vo);
			return viewResolverFormSuccess(query);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			System.out.println("�̰����μ������ֵ�������");
			return "�ϰ͵θ��Ͼ���";
		}
	}

	// �Խ��� ����� process�� �����ϴ� �޼���
	private String listProcess(HttpServletRequest request, HttpServletResponse response, List<ArticleVO> list,
			String query) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return viewResolverForm(query);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return viewResolverFormSuccess(query);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			System.out.println("���Ť���");
			return "���� �ƹ��͵� ���ߴµ� �� �����ϰٴٴ°���???";
		}
	}

	// �� ȭ�� ��θ� ������ִ� �޼ҵ� ����
	private String viewResolverForm(String viewName) {
		return "/WEB-INF/views/" + viewName + "Form.jsp";
	}

	// ���� ȭ�� ��θ� ������ִ� viewResolverSuccess()
	private String viewResolverFormSuccess(String viewName) {
		return "/WEB-INF/views/" + viewName + "Success.jsp";
	}

	// �Է��� �������� ���� �ٸ� �޼��带 ���� ó���ϴ� �޼ҵ� ����
	private void executeQuery(String query, ArticleVO vo) {
		if (query == "insert") {
			articleService.insert(vo);
		} else if (query == "updateFromListActive") {
			articleService.updateFromListActive(vo);
		} else if (query == "delete") {
			articleService.delete(vo);
		}
	}
}
