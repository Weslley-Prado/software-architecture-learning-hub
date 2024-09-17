@Controller
class ApiGraphqlController{

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentaryAboutArticleService commentaryAboutArticleService;

}