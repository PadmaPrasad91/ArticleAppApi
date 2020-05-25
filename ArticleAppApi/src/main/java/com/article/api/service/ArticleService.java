package com.article.api.service;

import java.util.List;

import com.article.api.entity.ArticleEntity;

public interface ArticleService {

	List<ArticleEntity> getAllArticlesByPageNumber(int pageNo, int pageSize);

	List<ArticleEntity> getAllArticles();

	ArticleEntity createArticle(ArticleEntity articleDetails);
}
