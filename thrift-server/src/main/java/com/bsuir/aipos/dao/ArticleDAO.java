package com.bsuir.aipos.dao;

import com.bsuir.aipos.thrift.Article;
import com.bsuir.aipos.thrift.Title;

import java.util.List;
import java.util.Set;

public interface ArticleDAO {

    void add(Article article) throws DAOException;

    void remove(Title title) throws  DAOException;

    String getContent(Title title) throws DAOException;

    void updateContent(Title title,String content) throws DAOException;

    Set<Title> getTitles() throws DAOException;
}
