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

	// 의존 주입
	@Autowired
	private ArticleService articleService;

	// 다음의 모든 메소드들에게 request.setAttribute("article", articleService.selectById(vo))을
	// 해주는 것과 같은 역할
	@ModelAttribute("article")
	public ArticleVO getArticle() {
		ArticleVO vo = new ArticleVO();
		return articleService.selectById(vo);
	}

	// 1. 게시글 등록 기능의 insrt() 메서드 정의
	@RequestMapping("/article/write.do")
	public String insert(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
		return process(request, response, vo, "insert");
	}

	// 2. 최근 게시글 조회 기능의 selectById() 메서드 정의
	@RequestMapping("/article/read.do")
	public String selectById(ArticleVO vo) {
		return "/WEB-INF/views/readArticle.jsp";
	}

	// 3. 최근 게시글 수정 기능의 update() 메서드 정의
	@RequestMapping("/article/modify.do")
	public String update(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
		return process(request, response, vo, "update");
	}

	// 4. 최근 게시글 삭제 기능의 update() 메서드 정의
	@RequestMapping("/article/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
		System.out.println("지울 id 머임??"+vo.getId());
		System.out.println("지울 지울 title머임??"+vo.getTitle());
		
		return process(request, response, vo, "delete");
	}

	@RequestMapping("/article/getList.do")
	public String getList(final Model model) {
		List<ArticleVO> list = articleService.getList();
		System.out.println("겟리스트테스트@@@@실행중aaa이셈???" + list.get(3).getTitle());
		model.addAttribute("ARTICLE_ID", list);
		return "/WEB-INF/views/getListForm.jsp";
	}

//	@RequestMapping("/article/selectFromList.do")
//	public String selectFromList(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, Model model) {
//		System.out.println("셀렉트프롬리스트 기능 실행중임??"+vo.getId());
//		model.addAttribute("ARTICLE_ID", vo);
//		return process(request, response, vo, "selectFromList");
//	}

	// 게시판에서 게시글 이동 버튼 클릭하면 해당 게시글 상세보기 페이지로 이동
	// 키값(id)를 주체로 jsp에서 get으로 param을 입력받아 이동하는 방식
	@RequestMapping({"/article/selectFromList.do", "/test" })
	public String selectFromList(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, Model model,
			@RequestParam("id") int id) {
		System.out.println("셀렉트프롬리스트 기능 실행중임?? 갖고온 id값 : >>>> " + id);

		model.addAttribute("ARTICLE_ID", articleService.selectFromList(vo));
		
//		System.out.println("requestAttribute 값 확인용 : " + (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
		
		return process(request, response, vo, "selectFromList");
	}
	
	
	
	// selectFromList에서 modify버튼 입력 시 실행되는 메서드
	@RequestMapping({"/article/updateFromList.do" })
	public String updateFromList(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, Model model) {
		System.out.println("셀렉트에서 업데이트로 이동했음?? 갖고온 id값 : >>>> ");
		System.out.println(vo.getId());
		System.out.println(vo.getTitle());
		
		model.addAttribute("ARTICLE_ID", articleService.selectFromList(vo));
		
		return process(request, response, vo, "updateFromList");
	}
	
	// modifyFromList에서 submit 버튼 입력 시 실행되는 메서드
	@RequestMapping("/article/updateFromListActive.do")
	public String updateFromListSuccess(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, Model model) {
		System.out.println("업데이트프롬리스트액티브가 실행중임??????");
		System.out.println(vo.getId());
		System.out.println(vo.getTitle());

//		model.addAttribute("ARTICLE_ID", articleService.selectFromList(vo));
		return process(request, response, vo, "updateFromListActive");
	}
	
//	// select 뷰에서 delete버튼 누르면실행되는 기능
//	@RequestMapping("/article/deleteFromSelect.do")
//	public String deleteFromSelect(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
//		System.out.println("딜리트프롬셀렉트가 실행중임??????????");
//		
//		return process(request, response, vo, "deleteFromSelect");
//	}
//	
	
	// GET, POST, 그 밖의 요청들을 분기 처리를 해주는 메서드 정의
	private String process(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, String query) {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			return viewResolverForm(query);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			executeQuery(query, vo);
			return viewResolverFormSuccess(query);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			System.out.println("이걸프로세스를왜돌림ㅋㅋ");
			return "암것두리턴안함";
		}
	}

	// 게시판 기능의 process를 수행하는 메서드
	private String listProcess(HttpServletRequest request, HttpServletResponse response, List<ArticleVO> list,
			String query) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return viewResolverForm(query);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return viewResolverFormSuccess(query);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			System.out.println("병신ㅋㅋ");
			return "옘병 아무것도 안했는데 뭘 리턴하겟다는거임???";
		}
	}

	// 폼 화면 경로를 만들어주는 메소드 정의
	private String viewResolverForm(String viewName) {
		return "/WEB-INF/views/" + viewName + "Form.jsp";
	}

	// 성공 화면 경로를 만들어주는 viewResolverSuccess()
	private String viewResolverFormSuccess(String viewName) {
		return "/WEB-INF/views/" + viewName + "Success.jsp";
	}

	// 입력한 쿼리문에 따라 다른 메서드를 실행 처리하는 메소드 정의
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
