@Service
class ArticleService{
    Map<String, ArticleData> articleData = new HashMap();

    //Method to find the article
    ArticleData articleById(String id){
        return articleData.get(id);
    }

    //Method to create the article
    Collection<ArticleData> createArticleData(String content){
        var newArticle = new ArticleData(UUID.randomUUID.toString(), cotent);
        articleData.put(newArticle, newArticle);
        return articleData.values();
    }
}