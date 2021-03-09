/*
简单错误记录

输入：路径名称，行号 （如：E:\V1R2\product\fpgadrive.c 1325）
将所有的记录统计并将结果输出：[文件名 代码行数 数目]，以空格隔开（fpgadrive.c 1325 1）

1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名，只记录文件的最后有效16个字符 (如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径

对于输出：
1. 结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
2. 如果超过8条记录，则只输出前8条记录.
3. 如果文件名的长度超过16个字符，则只输出后16个字符


注意事项：
1. 使用 " filename" + "linenum" 作为联合Key
2. 使用Map<,> map =  new LinkedHashmap<,>();
3. 使用.lastIndexOf("\\") 找到最后一个反斜杠的下标
4. 注意存在没有路径，路径就是文件名的情况
5. 使用LinkedList来保存Map对象Entry
6. 创建list后记得添加元素，一次把map的键值对对象全放进去
// List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
7. 需要重写Collections.sort()方法
*/

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //注意是LinkedHashMap 不是hashmap，
        //LinkedHashMap集合是一个有序的集合，元素存取顺序一致
        //这里使用<"文件名+行号">作为key
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        String key;
        String filename;
        String path;

        while(sc.hasNext()){
            // 路径 -> 文件名
            path = sc.next();
            int index = path.lastIndexOf("\\"); //找到最后一个反斜杠的下标
            //如果找不到说明只有文件名没有路径
            filename = index<0 ? path : path.substring(index+1);
            int linenum = sc.nextInt();
            //统计频率
            key = filename + " " + linenum;
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }
        sc.close();
        //对记录进行排序
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        //对LinkedList排序
        //这里要重写比较方法
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
                return (o2.getValue()-o1.getValue())==0 ? (o1.getValue()-o2.getValue()) : (o2.getValue() - o1.getValue());
            }
        });


        int m = 0;
        for (Map.Entry<String, Integer> item : list){
            if(m++<8){
                String[] str = item.getKey().split(" ");
                String name = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                String number = str[1];
                System.out.println(name+ " " + number + " " + item.getValue());
            }else{
                break;
            }
        }
    }
}
