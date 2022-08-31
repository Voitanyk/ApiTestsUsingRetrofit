public class Board {
    String id;
    public String name;
    public String key;
    public String token;
    public boolean defaultLabels;
    public boolean defaultLists;
    public String desc;
    public String idOrganization;
    public String idBoardSource;
    public String keepFromSource;
    public String powerUps;
    public String prefs_permissionLevel;
    public String prefs_voting;
    public String prefs_comments;
    public String prefs_invitations;
    public boolean prefs_selfJoin;
    public boolean prefs_cardCovers;
    public String prefs_background;
    public String prefs_cardAging;

    public Board(String name, String key, String token) {
        this.name = name;
        this.key = key;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getToken() {
        return token;
    }

    public Board(String id, String name, String key, String token) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.token = token;
    }

    public Board(String key, String token) {
        this.key = key;
        this.token = token;
    }

    public Board(String id, String name, String key, String token, boolean defaultLabels, boolean defaultLists, String desc, String idOrganization, String idBoardSource, String keepFromSource, String powerUps, String prefs_permissionLevel, String prefs_voting, String prefs_comments, String prefs_invitations, boolean prefs_selfJoin, boolean prefs_cardCovers, String prefs_background, String prefs_cardAging) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.token = token;
        this.defaultLabels = defaultLabels;
        this.defaultLists = defaultLists;
        this.desc = desc;
        this.idOrganization = idOrganization;
        this.idBoardSource = idBoardSource;
        this.keepFromSource = keepFromSource;
        this.powerUps = powerUps;
        this.prefs_permissionLevel = prefs_permissionLevel;
        this.prefs_voting = prefs_voting;
        this.prefs_comments = prefs_comments;
        this.prefs_invitations = prefs_invitations;
        this.prefs_selfJoin = prefs_selfJoin;
        this.prefs_cardCovers = prefs_cardCovers;
        this.prefs_background = prefs_background;
        this.prefs_cardAging = prefs_cardAging;
    }

  @Override
  public String toString() {
      return "{" +
              "\"id\":\"" + id + '\"' +
              ", \"name\":\"" + name + '\"'+
              '}';
  }

    public Board() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (!id.equals(board.id)) return false;
        return name.equals(board.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
