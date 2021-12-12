
import java.io.*;
public class Problem1 {
	public static void main(String[] args) {
		for(Object k : System.getProperties().keySet()) {
			String key = k.toString();
			String value = System.getProperty(key);
		}
		try {
			String path = System.getProperty("user.dir"); // 현재 디렉토리 가져오기
			File file = new File(path+"\\property.html");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("<!DOCTYPE html>\n");
			writer.write("<html charset=\"en\"\n");
			writer.write("<head>\n");
			writer.write("<meta charset=\"UTF-8\"/>");
			writer.write("<style>\n table{ border-collapse : collapse : width : 100%; }"
					+ "th, td { border : solid 1px #000; }\n");
			writer.write("</style>");
			writer.write("</head>\n");
			writer.write("<body>\n");
			writer.write("<table>\n");
			writer.write("<tr>\n");
			writer.write("<th>키</th>\n");
			writer.write("<th></th>\n");
			writer.write("</tr>\n");
			for(Object k : System.getProperties().keySet()) {
				writer.write("<tr>\n");
				String key = k.toString();
				String value = System.getProperty(key);
				writer.write("<td>"+key+"</td>\n");
				writer.write("<td>"+value+"</td>\n");
				writer.write("</tr>\n");
			}
			writer.write("</table>\n");
			writer.write("</body>\n");
			writer.write("</html>");
			
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
