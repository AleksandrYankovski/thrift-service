namespace java com.bsuir.aipos.thrift

struct Title {
    1 : string sportsmanFullName
    2 : string authorPhoneNumber
}


struct Article {
    1 : Title title
    2 : string content
}

exception ServiceServerException {
    1 : string message;
}

service SportsmanService {
    bool addArticle(1 : Article article) throws (1 : ServiceServerException e),
    bool removeArticle(1 : Title title) throws (1 : ServiceServerException e),
    string getContent(1 : Title title) throws (1 : ServiceServerException e),
    bool updateContent(1 : Title title, 2 : string content) throws (1 : ServiceServerException e),
    list<Title> getTitles() throws (1 : ServiceServerException e)
}