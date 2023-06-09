class FootballTeam {
    private String name;
    private String code;
    private String country;

    public FootballTeam(String name, String code, String country) {
        this.name = name;
        this.code = code;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }

    public int convertCodeToInt() {
        int result = 0;
        for (int i = 0; i < code.length(); i++) {
            result += (int) code.charAt(i);
        }
        return result;
    }
}