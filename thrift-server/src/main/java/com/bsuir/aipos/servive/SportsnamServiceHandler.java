package com.bsuir.aipos.servive;

import com.bsuir.aipos.dao.DAOException;
import com.bsuir.aipos.dao.impl.ArticleDAOImpl;
import com.bsuir.aipos.thrift.Article;
import com.bsuir.aipos.thrift.ServiceServerException;
import com.bsuir.aipos.thrift.SportsmanService;
import com.bsuir.aipos.thrift.Title;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class SportsnamServiceHandler implements SportsmanService.Iface {

    private com.bsuir.aipos.dao.ArticleDAO articleDAO = new ArticleDAOImpl();


    @Override
    public boolean addArticle(Article article) throws ServiceServerException, TException {
        try {
            Title title = article.getTitle();
            if (articleDAO.getContent(title) == null) {
                articleDAO.add(article);
                return true;
            }
            return false;
        } catch (DAOException e) {
            throw new ServiceServerException(e.getMessage());
        }
    }

    @Override
    public boolean removeArticle(Title title) throws ServiceServerException, TException {
        try {
            if (articleDAO.getContent(title) != null) {
                articleDAO.remove(title);
                return true;
            }
            return false;
        } catch (DAOException e) {
            throw new ServiceServerException(e.getMessage());
        }
    }

    @Override
    public String getContent(Title title) throws ServiceServerException, TException {
        try {
            return articleDAO.getContent(title);
        } catch (DAOException e) {
            throw new ServiceServerException(e.getMessage());
        }
    }

    @Override
    public boolean updateContent(Title title, String content) throws ServiceServerException, TException {
        try {
            if (articleDAO.getContent(title) != null) {
                articleDAO.updateContent(title, content);
                return true;
            }
            return false;
        } catch (DAOException e) {
            throw new ServiceServerException(e.getMessage());
        }
    }

    @Override
    public List<Title> getTitles() throws ServiceServerException, TException {
        try {
            return new ArrayList<>(articleDAO.getTitles());
        } catch (DAOException e) {
            throw new ServiceServerException(e.getMessage());
        }
    }
}
