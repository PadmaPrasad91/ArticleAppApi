package com.article.api.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.article.api.entity.ArticleEntity;
import com.article.api.repository.ArticleRepository;
import com.article.api.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public List<ArticleEntity> getAllArticles() {
		return articleRepository.findAll();
	}
	@Override
	public List<ArticleEntity> getAllArticlesByPageNumber(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<ArticleEntity> pagedResult = articleRepository.findAll(paging);
		return pagedResult.toList();
	}

	@Override
	public ArticleEntity createArticle(ArticleEntity articleDetails) {

		return articleRepository.save(articleDetails);
	}

	

}
