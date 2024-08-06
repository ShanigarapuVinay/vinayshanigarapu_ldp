class NotificationHandler {
    public void sendEmailNotification() {
        System.out.println("Sending email notification for PDF report...");
    }
}

class Report {
    public void generate() {
        System.out.println("Generating report...");
    }
}

class HTMLReport extends Report {
    @Override
    public void generate() {
        System.out.println("Generating HTML report...");
    }
}
class PDFReport extends Report {
    private NotificationHandler notificationHandler;

    public PDFReport(NotificationHandler notificationHandler) {
        this.notificationHandler = notificationHandler;
    }

    @Override
    public void generate() {
        System.out.println("Generating PDF report...");
        notificationHandler.sendEmailNotification();
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationHandler notificationHandler = new NotificationHandler();
        Report pdfReport = new PDFReport(notificationHandler);
        pdfReport.generate();
    }
}