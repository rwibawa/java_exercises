import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Stream {
    public static void main(String[] args) throws IOException {
        List<AppointmentProcedure> apptProcedures = new ArrayList<>();
        apptProcedures.add(new AppointmentProcedure(true, 1));
        apptProcedures.add(new AppointmentProcedure(false, 2));
        apptProcedures.add(new AppointmentProcedure(true, 3));
        apptProcedures.add(new AppointmentProcedure(false, 4));
        apptProcedures.add(new AppointmentProcedure(true, 5));

        System.out.println("apptProcedures:");
        apptProcedures.forEach(p ->
            System.out.println(String.format("{ historyId: %d, primaryProcedure: %b }",
                    p.getHistoryId(), p.isPrimaryProcedure()))
        );

        List<AppointmentProcedure> sortedAppts =
            apptProcedures.stream()
                .filter(p -> p.isPrimaryProcedure())
                .sorted((p1, p2) -> Integer.compare(p2.getHistoryId(), p1.getHistoryId()))
                .collect(toList());
        System.out.println("sortedAppts:");
        sortedAppts.forEach(p ->
                System.out.println(String.format("{ historyId: %d, primaryProcedure: %b }",
                        p.getHistoryId(), p.isPrimaryProcedure()))
        );
    }
}

class AppointmentProcedure {
    private boolean primaryProcedure;
    private int historyId;

    public boolean isPrimaryProcedure() {
        return primaryProcedure;
    }

    public void setPrimaryProcedure(boolean primaryProcedure) {
        this.primaryProcedure = primaryProcedure;
    }


    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }


    public AppointmentProcedure(boolean primaryProcedure, int historyId) {
        this.primaryProcedure = primaryProcedure;
        this.historyId = historyId;
    }
}
