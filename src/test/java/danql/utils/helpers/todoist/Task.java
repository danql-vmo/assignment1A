package danql.utils.helpers.todoist;


public class Task {
    class Due {
        private String string;
        private String date;
        private boolean recurring;
        private String dateTime;
        private String timezone;
    }

    private int id;
    private String description;
    private String project_id;
    private String section_id;
    private String content;
    private boolean is_completed;
    private int[] labelIds;
    private String parent_id;
    private int order;
    private int priority;
    private Due due;
    private String url;
    private int comment_count;
    private String assignee_id;
    private String assigner_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }

    public int[] getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(int[] labelIds) {
        this.labelIds = labelIds;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Due getDue() {
        return due;
    }

    public void setDue(Due due) {
        this.due = due;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(String assignee_id) {
        this.assignee_id = assignee_id;
    }

    public String getAssigner_id() {
        return assigner_id;
    }

    public void setAssigner_id(String assigner_id) {
        this.assigner_id = assigner_id;
    }

}
