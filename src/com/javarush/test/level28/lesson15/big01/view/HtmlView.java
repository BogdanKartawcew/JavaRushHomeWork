package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by MyWORID on 12.05.2017.
 */
public class HtmlView implements View
{
    private final String filePath =
            "./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/")
                    + "/vacancies.html";
    private Controller controller;
    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "utf-8");
    }
    private void updateFile(String updatedFile) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(updatedFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private String getUpdatedFileContent(List<Vacancy> vacancyList) {
        String updatedFileContent;
        try {
            Document document = getDocument();
            Element tempElement = document.select("[class*=\"template\"]").first();
            //getting pattern Element for new vacancies
            Element pattern = tempElement.clone();
            pattern.removeAttr("style");
            pattern.removeClass("template");
            //remove all tags <tr> with only one class="vacancy"
            document.select("tr[class=\"vacancy\"]").remove();
            //adding new Vacancies to result page updatedFileContent
            for (Vacancy vacancy : vacancyList) {
                Element newVacancyElement = pattern.clone();
                newVacancyElement.select("[class=\"city\"]").
                        first().text(vacancy.getCity());
                newVacancyElement.select("[class=\"companyName\"]").
                        first().text(vacancy.getCompanyName());
                newVacancyElement.select("[class=\"salary\"]").
                        first().text(vacancy.getSalary());
                Element link = newVacancyElement.select("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                tempElement.before(newVacancyElement.outerHtml());
            }
            updatedFileContent = document.html();
        } catch (Exception e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return updatedFileContent;
    }
    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));
    }
    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
