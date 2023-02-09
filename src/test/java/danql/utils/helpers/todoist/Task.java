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
    private String projectId;
    private int sectionId;
    private String content;
    private String description;
    private boolean completed;
    private int[] labelIds;
    private int parentId;
    private int order;
    private int priority;
    private Due due;
    private String url;
    private int commentCount;
    private int assignee;
    private int assigner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int[] getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(int[] labelIds) {
        this.labelIds = labelIds;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getAssignee() {
        return assignee;
    }

    public void setAssignee(int assignee) {
        this.assignee = assignee;
    }

    public int getAssigner() {
        return assigner;
    }

    public void setAssigner(int assigner) {
        this.assigner = assigner;
    }

}
