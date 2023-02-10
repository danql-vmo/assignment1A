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
    private String parent_id;
    private Integer order;
    private Integer comment_count;
    private Boolean is_shared;

    public Boolean getFavorite() {
        return is_favorite;
    }

    public void setFavorite(Boolean favorite) {
        is_favorite = favorite;
    }

    public String getView_style() {
        return view_style;
    }

    public void setView_style(String view_style) {
        this.view_style = view_style;
    }

    private Boolean is_favorite;
    private Boolean is_inbox_project;
    private Boolean is_team_inbox;
    private String view_style;
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

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Boolean getIs_shared() {
        return is_shared;
    }

    public void setIs_shared(Boolean is_shared) {
        this.is_shared = is_shared;
    }

    public Boolean getIs_inbox_project() {
        return is_inbox_project;
    }

    public void setIs_inbox_project(Boolean is_inbox_project) {
        this.is_inbox_project = is_inbox_project;
    }

    public Boolean getIs_team_inbox() {
        return is_team_inbox;
    }

    public void setIs_team_inbox(Boolean is_team_inbox) {
        this.is_team_inbox = is_team_inbox;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
