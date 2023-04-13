



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class Main
{
    public static void main(String args[]) throws IOException {

        long startTime = System.currentTimeMillis();

        AbbTree a = new AbbTree();
        treeMaker(a);

//        a.printBranch(0);



        //Creating a File object for directory
        File directoryPath = new File("C:\\Users\\moham\\Cosc320\\Keyword replacement in a corpus\\test2");
        //List of all files and directories
        File filesList[] = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        for(File file : filesList) {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                try {
                    String[] columns = st.split(",");
                    String forthColumn = columns[3];

                    String[] words = forthColumn.split("\\s+");

                    // Output the array of words
                    for (String word : words) {
                        krc k = new krc(word, a);
                        String replaceWord = k.search(word, a);
                        if (!word.equals(replaceWord)) {
//                            System.out.println("word: " + word + " replaceWord: " + replaceWord);
                        }
                    }

                }catch(ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
            br.close();
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
    }

    static void treeMaker(AbbTree a) {
        //A letter
        a.insert("AEM", "Adobe Experience Manager");
        a.insert("AEO", "American Eagle Outfitters");
        a.insert("AFA", "Air Force Academy");
        a.insert("AFB", "Air Force Base");
        a.insert("AFI", "Air Force Instruction");
        a.insert("AFM", "Air Force Manual");
        a.insert("AFO", "Air Force One");
        a.insert("AFP", "Agence France-Presse");
        a.insert("AFS", "American Field Service");
        a.insert("AG", "Attorney General");
        a.insert("AGM", "annual general meeting");
        a.insert("AGP", "Accelerated Graphics Port");
        a.insert("AH", "Anno Hegirae");
        a.insert("AHS", "American Horror Story");
        a.insert("AI", "artificial intelligence");
        a.insert("AIA", "American Institute of Architects");
        a.insert("AICPA", "American Institute of Certified Public Accountants");
        a.insert("AIDS", "Acquired Immune Deficiency Syndrome");
        a.insert("AIG", "American International Group");
        a.insert("AIM", "AOL Instant Messenger");
        a.insert("AIP", "Artificial Intelligence Platform");
        a.insert("AIR", "All India Radio");
        a.insert("AIT", "American Institute in Taiwan");
        a.insert("AKA", "also known as");
        a.insert("AL", "Alabama");
        a.insert("ALA", "American Library Association");
        a.insert("ALJ", "administrative law judge");
        a.insert("AM", "ante meridiem");
        a.insert("AMA", "American Medical Association");
        a.insert("AMD", "Advanced Micro Devices");
        a.insert("AMEX", "American Stock Exchange");
        a.insert("AMF", "Amplitude Modulation Frequency");
        a.insert("AMG", "Affalterbach, Germany");
        a.insert("AMOLED", "Active-Matrix Organic Light-Emitting Diode");
        a.insert("AMR", "Adaptive Multi-Rate");
        a.insert("AMS", "Amsterdam Schiphol Airport");
        a.insert("AMT", "alternative minimum tax");
        a.insert("AN", "Airman's Note");
        a.insert("ANPR", "automatic number plate recognition");
        a.insert("ANSI", "American National Standards Institute");
        a.insert("ANTM", "America's Next Top Model");
        a.insert("AO", "Area of Operation");
        a.insert("AOC", "area of concern");
        a.insert("AOD", "Angle of Departure");
        a.insert("AOE", "Area of Effect");
        a.insert("AOR", "Area of Responsibility");
        a.insert("AP", "Associated Press");
        a.insert("APA", "American Psychological Association");
        a.insert("APC", "American Power Conversion");
        a.insert("APL", "A Programming Language");
        a.insert("APN", "Access Point Name");
        a.insert("APO", "Army Post Office");
        a.insert("APP", "application");
        a.insert("APR", "Annual Percentage Rate");
        a.insert("APS", "American Physical Society");
        a.insert("APT", "Advanced Persistent Threat");
        a.insert("APU", "Auxiliary Power Unit");
        a.insert("AQ", "Air Quality");
        a.insert("AR", "Augmented Reality");
        a.insert("ARC", "American Red Cross");
        a.insert("AFAIK", "as far as I know");
        a.insert("AFK", "away from keyboard");
        a.insert("AMA", "ask me anything");
        a.insert("ASL", "age/sex/location");
        a.insert("ATB", "all the best");
        a.insert("ATM", "automated teller machine");
        a.insert("ATP", "according to plan");
        a.insert("AFAIR", "as far as I remember");
        a.insert("ADN", "any day now");
        a.insert("AOP", "area of practice");
        a.insert("AOD", "all of the above");
        a.insert("AOM", "age of majority");
        a.insert("APAC", "Asia-Pacific");
        a.insert("AQL", "acceptable quality level");
        a.insert("AR", "augmented reality");
        a.insert("ARP", "address resolution protocol");
        a.insert("ASAP", "as soon as possible");
        a.insert("ASCII", "American Standard Code for Information Interchange");
        a.insert("ASMR", "autonomous sensory meridian response");
        a.insert("AST", "Atlantic Standard Time");
        a.insert("ATA", "Actual Time of Arrival");
        a.insert("ATD", "Actual Time of Departure");
        a.insert("AUV", "autonomous underwater vehicle");
        a.insert("AV", "audio/video");
        a.insert("AVG", "average");
        a.insert("AWS", "Amazon Web Services");
        a.insert("A&E", "arts and entertainment");
        a.insert("A&P", "anatomy and physiology");
        a.insert("A&F", "Abercrombie & Fitch");
        a.insert("A&M", "arts and music");
        a.insert("A&W", "A&W Restaurants");
        a.insert("AA", "Alcoholics Anonymous");
        a.insert("AAA", "American Automobile Association");
        a.insert("AAC", "Advanced Audio Coding");
        a.insert("AARP", "American Association of Retired Persons");
        a.insert("AB", "Alberta");
        a.insert("ABC", "American Broadcasting Company");
        a.insert("ABM", "account-based marketing");
        a.insert("ABO", "blood type system");
        a.insert("ABS", "anti-lock braking system");
        a.insert("AC", "alternating current");
        a.insert("ACA", "Affordable Care Act");
        a.insert("ACC", "Atlantic Coast Conference");
        a.insert("ACD", "automatic call distributor");
        a.insert("ACDC", "Alternating Current/Direct Current");
        a.insert("ACE", "Angiotensin-Converting Enzyme");
        a.insert("ACID", "Atomicity, Consistency, Isolation, Durability");
        a.insert("ACL", "access control list");
        a.insert("ACM", "Association for Computing Machinery");
        a.insert("ACME", "A Company that Makes Everything");
        a.insert("ACORN", "Association of Community Organizations for Reform Now");
        a.insert("ACP", "Automatic Colt Pistol");
        a.insert("ACR", "American College of Radiology");
        a.insert("ACS", "American Cancer Society");
        a.insert("ACT", "American College Testing");
        a.insert("AD", "Anno Domini");
        a.insert("ADA", "Americans with Disabilities Act");
        a.insert("ADHD", "Attention Deficit Hyperactivity Disorder");
        a.insert("ADI", "Analog Devices, Inc.");

        a.insert("BA", "Bachelor of Arts");
        a.insert("BAA", "British Airport Authority");
        a.insert("BAC", "Blood Alcohol Content");
        a.insert("BAE", "British Aerospace");
        a.insert("BAL", "Basic Assembly Language");
        a.insert("BAT", "Basic Attention Token");
        a.insert("BB", "BlackBerry");
        a.insert("BBB", "Better Business Bureau");
        a.insert("BBC", "British Broadcasting Corporation");
        a.insert("BBM", "BlackBerry Messenger");
        a.insert("BC", "Before Christ");
        a.insert("BCG", "Boston Consulting Group");
        a.insert("BCL", "Base Class Library");
        a.insert("BCS", "British Computer Society");
        a.insert("BD", "Birthdate");
        a.insert("BDC", "Business Development Company");
        a.insert("BDS", "Bureau of Diplomatic Security");
        a.insert("BE", "Bachelor of Education");
        a.insert("BFA", "Bachelor of Fine Arts");
        a.insert("BFF", "Best Friends Forever");
        a.insert("BFS", "Breadth-First Search");
        a.insert("BGA", "Ball Grid Array");
        a.insert("BHP", "Brake Horsepower");
        a.insert("BI", "Business Intelligence");
        a.insert("BIM", "Building Information Modeling");
        a.insert("BIO", "Basic Input/Output");
        a.insert("BIS", "Bank for International Settlements");
        a.insert("BIT", "Binary Digit");
        a.insert("BLOG", "Weblog");
        a.insert("BLT", "Bacon, Lettuce, and Tomato");
        a.insert("BMW", "Bavarian Motor Works");
        a.insert("BNP", "British National Party");
        a.insert("BOGO", "Buy One, Get One");
        a.insert("BOM", "Bill of Materials");
        a.insert("BPA", "Business Process Automation");
        a.insert("BPM", "Business Process Management");
        a.insert("BPO", "Business Process Outsourcing");
        a.insert("BPS", "Bits Per Second");
        a.insert("BRB", "Be Right Back");
        a.insert("BRI", "Basic Rate Interface");
        a.insert("BRS", "Broadcasting Satellite");
        a.insert("BS", "Bachelor of Science");
        a.insert("BSA", "Boy Scouts of America");
        a.insert("BSOD", "Blue Screen of Death");
        a.insert("BST", "British Summer Time");
        a.insert("BT", "British Telecommunications");
        a.insert("BTO", "Build to Order");
        a.insert("BTS", "Bangtan Sonyeondan");
        a.insert("BTU", "British Thermal Unit");
        a.insert("BV", "Bouvet Island");
        a.insert("BVD", "Bovine Viral Diarrhea");
        a.insert("BYOD", "Bring Your Own Device");

        a.insert("CA", "California");
        a.insert("CAD", "Computer-Aided Design");
        a.insert("CAM", "Computer-Aided Manufacturing");
        a.insert("CAPTCHA", "Completely Automated Public Turing Test To Tell Computers and Humans Apart");
        a.insert("CAT", "Computer-Aided Translation");
        a.insert("CBA", "Commonwealth Bank of Australia");
        a.insert("CC", "Carbon Copy");
        a.insert("CCC", "Chinese Communist Party");
        a.insert("CD", "Compact Disc");
        a.insert("CEO", "Chief Executive Officer");
        a.insert("CERN", "European Organization for Nuclear Research");
        a.insert("CF", "Compact Flash");
        a.insert("CGI", "Common Gateway Interface");
        a.insert("CI", "Continuous Integration");
        a.insert("CIO", "Chief Information Officer");
        a.insert("CIS", "Commonwealth of Independent States");
        a.insert("CIT", "Citation Index");
        a.insert("CJ", "Chief Justice");
        a.insert("CLI", "Command Line Interface");
        a.insert("CMA", "Certified Management Accountant");
        a.insert("CMOS", "Complementary Metal-Oxide Semiconductor");
        a.insert("CMS", "Content Management System");
        a.insert("CNC", "Computer Numerical Control");
        a.insert("CO", "Carbon Monoxide");
        a.insert("COCOMO", "Constructive Cost Model");
        a.insert("COO", "Chief Operating Officer");
        a.insert("COTS", "Commercial Off-The-Shelf");
        a.insert("CPU", "Central Processing Unit");
        a.insert("CR", "Credit");
        a.insert("CRM", "Customer Relationship Management");
        a.insert("CRT", "Cathode Ray Tube");
        a.insert("CSS", "Cascading Style Sheets");
        a.insert("CSV", "Comma-Separated Values");
        a.insert("CT", "Computed Tomography");
        a.insert("CTO", "Chief Technology Officer");
        a.insert("CU", "See You");
        a.insert("CV", "Curriculum Vitae");
        a.insert("CVD", "Chemical Vapor Deposition");
        a.insert("CXML", "Commerce XML");

        a.insert("DAO", "Decentralized Autonomous Organization");
        a.insert("DAT", "Digital Audio Tape");
        a.insert("DB", "Database");
        a.insert("DBA", "Database Administrator");
        a.insert("DC", "Direct Current");
        a.insert("DDR", "Double Data Rate");
        a.insert("DECT", "Digital Enhanced Cordless Telecommunications");
        a.insert("DFS", "Distributed File System");
        a.insert("DHTML", "Dynamic HTML");
        a.insert("DIMM", "Dual In-Line Memory Module");
        a.insert("DIN", "Deutsches Institut für Normung");
        a.insert("DIP", "Dual In-Line Package");
        a.insert("DLP", "Digital Light Processing");
        a.insert("DMA", "Direct Memory Access");
        a.insert("DNS", "Domain Name System");
        a.insert("DOA", "Dead On Arrival");
        a.insert("DOM", "Document Object Model");
        a.insert("DOS", "Disk Operating System");
        a.insert("DPI", "Dots Per Inch");
        a.insert("DRAM", "Dynamic Random Access Memory");
        a.insert("DSL", "Digital Subscriber Line");
        a.insert("DSP", "Digital Signal Processing");
        a.insert("DVD", "Digital Versatile Disc");
        a.insert("DVI", "Digital Visual Interface");
        a.insert("DWG", "Drawing");
        a.insert("DXF", "Drawing Exchange Format");
        a.insert("DZ", "Dzongkha (Bhutan)");

        a.insert("EOD", "End of Day");
        a.insert("ERP", "Enterprise Resource Planning");
        a.insert("ESB", "Enterprise Service Bus");
        a.insert("EC2", "Elastic Compute Cloud");
        a.insert("ECS", "Elastic Container Service");
        a.insert("EFS", "Elastic File System");
        a.insert("ELB", "Elastic Load Balancer");
        a.insert("EJB", "Enterprise JavaBeans");
        a.insert("EKG", "Electrocardiogram");
        a.insert("EMR", "Electronic Medical Record");
        a.insert("EOF", "End of File");
        a.insert("EOL", "End of Line");
        a.insert("EPROM", "Erasable Programmable Read-Only Memory");
        a.insert("EULA", "End User License Agreement");
        a.insert("EVDO", "Evolution-Data Optimized");
        a.insert("EVPN", "Ethernet Virtual Private Network");
        a.insert("EXE", "Executable");
        a.insert("EIDE", "Enhanced Integrated Drive Electronics");
        a.insert("EAI", "Enterprise Application Integration");
        a.insert("EDA", "Electronic Design Automation");
        a.insert("EDI", "Electronic Data Interchange");
        a.insert("EFT", "Electronic Funds Transfer");
        a.insert("EGP", "Exterior Gateway Protocol");
        a.insert("EJB", "Enterprise JavaBeans");
        a.insert("EOD", "End Of Day");
        a.insert("EOS", "End Of Support");
        a.insert("EOL", "End Of Life");
        a.insert("EOT", "End Of Transmission");
        a.insert("ERP", "Enterprise Resource Planning");
        a.insert("ESB", "Enterprise Service Bus");
        a.insert("ETL", "Extract, Transform, Load");
        a.insert("EULA", "End User License Agreement");
        a.insert("EWS", "Exchange Web Services");

        a.insert("FAQ", "Frequently Asked Questions");
        a.insert("FIFO", "First In, First Out");
        a.insert("FTP", "File Transfer Protocol");
        a.insert("FPGA", "Field-Programmable Gate Array");
        a.insert("FHD", "Full High Definition");
        a.insert("FHD", "Full HD");
        a.insert("FLOPS", "Floating Point Operations Per Second");
        a.insert("FMC", "Fixed Mobile Convergence");
        a.insert("FOMO", "Fear Of Missing Out");
        a.insert("FSF", "Free Software Foundation");
        a.insert("FUD", "Fear, Uncertainty, and Doubt");
        a.insert("FWIW", "For What It's Worth");
        a.insert("FLOSS", "Free/Libre/Open-Source Software");
        a.insert("FMCG", "Fast-Moving Consumer Goods");
        a.insert("FMEA", "Failure Mode and Effects Analysis");
        a.insert("FUPA", "Fat Upper Pubic Area");
        a.insert("FBO", "For Business Only");
        a.insert("FM", "Frequency Modulation");
        a.insert("FMEA", "Failure Modes and Effects Analysis");
        a.insert("FPS", "Frames Per Second");
        a.insert("FQDN", "Fully Qualified Domain Name");
        a.insert("FUD", "Fear, Uncertainty, and Doubt");
        a.insert("FYI", "For Your Information");

        a.insert("GPS", "Global Positioning System");
        a.insert("GUI", "Graphical User Interface");
        a.insert("GIF", "Graphics Interchange Format");
        a.insert("GPU", "Graphics Processing Unit");
        a.insert("GSM", "Global System for Mobile Communications");
        a.insert("Gbps", "Gigabits per second");
        a.insert("GHz", "Gigahertz");
        a.insert("GB", "Gigabyte");
        a.insert("GIGO", "Garbage In, Garbage Out");
        a.insert("GIGO", "Garbage In, Gospel Out");
        a.insert("GNOME", "GNU Network Object Model Environment");
        a.insert("GNU", "GNU's Not Unix");
        a.insert("GPL", "General Public License");
        a.insert("GUI", "Graphical User Interface");
        a.insert("GBit", "Gigabit");
        a.insert("GID", "Group Identifier");
        a.insert("GPIO", "General Purpose Input/Output");
        a.insert("GPRS", "General Packet Radio Service");
        a.insert("GPT", "GUID Partition Table");
        a.insert("GUI", "Graphical User Interface");
        a.insert("GIS", "Geographic Information System");
        a.insert("GMT", "Greenwich Mean Time");
        a.insert("GPG", "GNU Privacy Guard");
        a.insert("GNU", "GNU's Not Unix");
        a.insert("GPIO", "General Purpose Input/Output");
        a.insert("GPL", "General Public License");
        a.insert("GUI", "Graphical User Interface");

        a.insert("HTML", "HyperText Markup Language");
        a.insert("HTTP", "HyperText Transfer Protocol");
        a.insert("HTTPS", "HyperText Transfer Protocol Secure");
        a.insert("HDD", "Hard Disk Drive");
        a.insert("HDMI", "High-Definition Multimedia Interface");
        a.insert("HDTV", "High-Definition Television");
        a.insert("HPC", "High-Performance Computing");
        a.insert("HSDPA", "High-Speed Downlink Packet Access");
        a.insert("HSUPA", "High-Speed Uplink Packet Access");
        a.insert("HTML5", "HyperText Markup Language version 5");
        a.insert("H.264", "Advanced Video Coding (AVC)");
        a.insert("H.265", "High Efficiency Video Coding (HEVC)");
        a.insert("HTTP/2", "HyperText Transfer Protocol version 2");
        a.insert("HPC", "High-Performance Computing");
        a.insert("HCI", "Human-Computer Interaction");
        a.insert("HID", "Human Interface Device");
        a.insert("HTTP/3", "HyperText Transfer Protocol version 3");
        a.insert("HDFS", "Hadoop Distributed File System");
        a.insert("HBase", "Hadoop Database");
        a.insert("HTML5", "HyperText Markup Language version 5");
        a.insert("HTML", "HyperText Markup Language");
        a.insert("HTTP", "HyperText Transfer Protocol");
        a.insert("HTTPS", "HyperText Transfer Protocol Secure");

        a.insert("I/O", "Input/Output");
    }
}