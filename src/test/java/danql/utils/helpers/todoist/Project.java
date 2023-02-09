package danql.utils.helpers.todoist;


public class Project {

    public enum ProjectColor {
        berry_red(30),
        red(31),
        orange(32),
        yellow(33),
        olive_green(34),
        lime_green(35),
        green(36),
        mint_green(37),
        teal(38),
        sky_blue(39),
        light_blue(40),
        blue(41),
        grape(42),
        violet(43),
        lavender(44),
        magenta(45),
        salmon(46),
        charcoal(47),
        grey(48),
        taupe(49);

        private int _colorId;

        ProjectColor(int colorId) {
            this._colorId = colorId;
        }

        public int getValue() {
            return _colorId;
        }

        public static ProjectColor fromInt(int i) {
            for (ProjectColor b : ProjectColor.values()) {
                if (b.getValue() == i) {
                    return b;
                }
            }
            return berry_red;
        }
    }


    private Integer id;
    private String name;
    private ProjectColor color;
    private String parentID;
    private Integer order;
    private Integer commentCount;
    private Boolean isShared;

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public String getViewStyle() {
        return viewStyle;
    }

    public void setViewStyle(String viewStyle) {
        this.viewStyle = viewStyle;
    }

    private Boolean isFavorite;
    private Boolean isInboxProject;
    private Boolean isTeamInbox;
    private String viewStyle;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectColor getColor() {
        return color;
    }

    public void setColor(ProjectColor color) {
        this.color = color;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Boolean getIsShared() {
        return isShared;
    }

    public void setIsShared(Boolean isShared) {
        this.isShared = isShared;
    }

    public Boolean getIsInboxProject() {
        return isInboxProject;
    }

    public void setIsInboxProject(Boolean isInboxProject) {
        this.isInboxProject = isInboxProject;
    }

    public Boolean getIsTeamInbox() {
        return isTeamInbox;
    }

    public void setIsTeamInbox(Boolean isTeamInbox) {
        this.isTeamInbox = isTeamInbox;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
