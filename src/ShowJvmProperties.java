import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.util.Map;
import java.util.Properties;

public class ShowJvmProperties {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

//        for (Map.Entry entry : properties.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//
//        properties.forEach((key, value) -> System.out.println(key + "\t" + value));

//        outputEnv();

//        outputSystemMemory();
//        outputMemoryFromMXBean();
        outputOperatingSystemInfo();
    }

    private static void outputEnv() {
        Map<String, String> env = System.getenv();

        env.forEach((key, value) -> System.out.println(key + "\t" + value));
    }

    private static void outputSystemMemory() {
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();

        long totalMemory = runtime.totalMemory();

        System.out.println("Memory: free " + freeMemory + "\tmax\t" + maxMemory + "\ttotal\t" + totalMemory);

    }

    private static void outputMemoryFromMXBean() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        System.out.println("Heap memory usage " + ((MemoryMXBean) memoryMXBean).getHeapMemoryUsage());
    }

    private static void outputOperatingSystemInfo() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

        String name = operatingSystemMXBean.getName();
        String version = operatingSystemMXBean.getVersion();
        String arch = operatingSystemMXBean.getArch();
        int availableProcessors = operatingSystemMXBean.getAvailableProcessors();
        double systemLoadAverage = operatingSystemMXBean.getSystemLoadAverage();

        System.out.println("OS: " + name + " " + version);
        System.out.println("Architecture: " + arch + " processors: " + availableProcessors);

        System.out.println("Current load average: " + systemLoadAverage);
    }
}
