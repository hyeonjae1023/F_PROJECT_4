package com.moviement.controller;

import java.util.List;
import java.util.Scanner;

import com.moviement.container.Container;
import com.moviement.dto.MovieArticle;
import com.moviement.service.MemberService;
import com.moviement.service.MovieArticleService;

public class MovieArticleController extends Controller {
	private Scanner sc;
	private int selectNum;
	private MemberService memberService;
	private MovieArticleService movieArticleService;
	private Session session;

	public MovieArticleController(Scanner isc) {
		this.sc = isc;
		memberService = Container.memberService;
		session = Container.getSession();
	}

	public void doAction(int selectNum) {
		this.selectNum = selectNum;

		switch (selectNum) {
		case 2: // 상영 중인 영화 목록 페이지
			showMovieList();
			break;
		case 3: // 리뷰 & 평점 페이지
			showCommentList();
			break;
		case 4: // 영화 추천 페이지
			doRecommend();
			break;
		case 5: // 영화 예매 페이지
			doTicketing();
			break;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
	}

	public void showMovieList() {
		System.out.println("=== === === MOVIELIST === === ===");
		List<MovieArticle> forPrintMovieArticles = movieArticleService.getMovieArticles();
//		
//		System.out.println("=== === === Movie List === === ===");
//		for (int i = forPrintMovieArticles.size() - 1; i >= 0; i--) {
//			MovieArticle movieArticle = forPrintMovieArticles.get(i);
//			String writerName = memberService.getMemberByNameId(movieArticle.memberId);
//
//			System.out.println(" 번호 | 제목");
//			System.out.printf("%4d|%15s\n", movieArticle.id, movieArticle.title);
//		}
	}

	private void showCommentList() {

	}

	private void doRecommend() {

	}

	private void doTicketing() {

	}
}