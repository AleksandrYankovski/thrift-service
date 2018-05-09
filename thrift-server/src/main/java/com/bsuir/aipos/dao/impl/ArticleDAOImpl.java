package com.bsuir.aipos.dao.impl;

import com.bsuir.aipos.dao.ArticleDAO;
import com.bsuir.aipos.dao.DAOException;
import com.bsuir.aipos.thrift.Article;
import com.bsuir.aipos.thrift.Title;

import java.util.*;

public class ArticleDAOImpl implements com.bsuir.aipos.dao.ArticleDAO {

    private Map<Title, Article> articles = new HashMap<>();

    public ArticleDAOImpl() {
        Title title = new Title("dfsfd", "dfs");
        articles.put(title, new Article(title, "dfsgh"));
    }

    @Override
    public void add(Article article) throws DAOException {
        articles.put(article.getTitle(), article);
    }

    @Override
    public void remove(Title title) throws DAOException {
        articles.remove(title);
    }

    @Override
    public String getContent(Title title) throws DAOException {
        return articles.get(title).getContent();
    }

    @Override
    public void updateContent(Title title, String content) throws DAOException {
        Article newArticle = new Article();
        newArticle.setContent(content);
        newArticle.setTitle(title);
        articles.replace(title, articles.get(title), newArticle);
    }

    @Override
    public Set<Title> getTitles() throws DAOException {
        return articles.keySet();
    }
}
