import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<FootballTeam> footballTeams = new ArrayList<>();

    public static void main(String[] args) {
        readJSONFile("src/5_6276077805172164786.json");
        displayData();
        searchClub();
    }

    private static void readJSONFile(String filePath) {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fileReader = new FileReader(filePath);
            Object objContent = jsonParser.parse(fileReader);
            JSONObject content = new JSONObject(objContent.toString());
//            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content.getJSONArray("clubs"));
//            System.out.println(jsonArray);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String code = jsonObject.optString("code");
                String country = jsonObject.getString("country");

                FootballTeam footballTeam = new FootballTeam(name, code, country);
                footballTeams.add(footballTeam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayData() {
        System.out.println("Data in JSON File:");
        for (FootballTeam team : footballTeams) {
            System.out.println("Name: " + team.getName());
            System.out.println("Code: " + team.getCode());
            System.out.println("Country: " + team.getCountry());
            System.out.println();
        }
    }

    private static void searchClub() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cari nama club :");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (FootballTeam team : footballTeams) {
            if (team.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Hasil Pencarian Club");
                System.out.println("Name: " + team.getName());
                System.out.println("Code: " + team.getCode());
                System.out.println("Country: " + team.getCountry());
                System.out.println();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Club not found.");
        }

        scanner.close();
    }
}