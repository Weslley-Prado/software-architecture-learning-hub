@Service
class CommentaryAboutArticleService{
    Map<String, CommentaryAboutArticle> commentaryAboutArticle = new HashMap();

    //Method to create the article
    Collection<CommentaryAboutArticle> createCommentaryAboutArticle(String content, String articleId){
        var newCommentaryAboutArticle = new CommentaryAboutArticle(UUID.randomUUID.toString(), cotent, articleId);
        commentaryAboutArticle.put(newArticle, newArticle);
        return commentaryAboutArticle.values();
    }

    //Method to find the article
    Collection<CommentaryAboutArticle> findByArticleData(String articleId){
        return commentaryAboutArticle.get().stream().filter(commentary -> commentary.articleId().equals(articleId)).toList();
    }
}