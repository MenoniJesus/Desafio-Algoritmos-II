import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Estatisticas {

    private java.nio.file.Files Files;

    public void calcularMaiorMenorMedia(List<Aluno> alunos) throws IOException {

        Path path = Path.of("C:\\Users\\conta\\IdeaProjects\\VideoLerCriarDeletarTXT\\src\\Maior&MenorMedia.txt");
        if(Files.notExists(path)){
            Files.createFile(path);
        }

        Aluno alunoComMaiorMedia = alunos.get(0);
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() > alunoComMaiorMedia.calcularMedia()) {
                alunoComMaiorMedia = aluno;
            }
        }
        Aluno alunoComMenorMedia = alunos.get(0);
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() < alunoComMenorMedia.calcularMedia()) {
                alunoComMenorMedia = aluno;
            }
        }
        String conteudo = "Aluno com maior média:\nID: " + alunoComMaiorMedia.id + " | Notas: " + alunoComMaiorMedia.notas + " | Media: " + alunoComMaiorMedia.calcularMedia() + "\n" +
                            "----------------------------------------------------------------------------------------" + "\n" +
                          "Aluno com menor média:\nID: " + alunoComMenorMedia.id + " | Notas: " + alunoComMenorMedia.notas + " | Media: " + alunoComMenorMedia.calcularMedia();

        Files.writeString(path, conteudo);
    }

    public void classificarAlunosPorDisciplina(List<Aluno> alunos) throws IOException {
        Path pathAprovadosReprovados = Path.of("C:\\Users\\conta\\IdeaProjects\\VideoLerCriarDeletarTXT\\src\\QuantidadeAprovadosReprovadosPorDisciplina.txt");

        if(Files.notExists(pathAprovadosReprovados)){
            Files.createFile(pathAprovadosReprovados);
        }

        int quantidadeTotalDeAlunos = alunos.size();
        int aprovadosDisciplina1 = 0, aprovadosDisciplina2 = 0, aprovadosDisciplina3 = 0, aprovadosDisciplina4 = 0;
        int reprovadosDisciplina1 = 0, reprovadosDisciplina2 = 0, reprovadosDisciplina3 = 0, reprovadosDisciplina4 = 0;

        for (Aluno aluno : alunos) {
            for (int i = 0; i < aluno.notas.size(); i++) {
                if (aluno.notas.get(i) >= 70) {
                    switch (i) {
                        case 0 -> aprovadosDisciplina1++;
                        case 1 -> aprovadosDisciplina2++;
                        case 2 -> aprovadosDisciplina3++;
                        case 3 -> aprovadosDisciplina4++;
                    }
                } else {
                    switch (i) {
                        case 0 -> reprovadosDisciplina1++;
                        case 1 -> reprovadosDisciplina2++;
                        case 2 -> reprovadosDisciplina3++;
                        case 3 -> reprovadosDisciplina4++;
                    }
                }
            }
        }
        String conteudo = String.format("Quantidade total de alunos: %d\n-------------------------------------------------------\n" +
                                        "Quantidade de alunos aprovados e reprovados por disciplina: \n-------------------------------------------------------\n" +
                                        "Foram aprovados:\n %d alunos na disciplina 1.\n %d alunos na disciplina 2.\n %d alunos na disciplina 3.\n %d alunos na disciplina 4.\n-------------------------------------------------------\n" +
                                        "Foram reprovados:\n %d alunos na disciplina 1.\n %d alunos na disciplina 2.\n %d alunos na disciplina 3.\n %d alunos na disciplina 4.\n-------------------------------------------------------\n",
                                        quantidadeTotalDeAlunos, aprovadosDisciplina1, aprovadosDisciplina2, aprovadosDisciplina3, aprovadosDisciplina4,
                                        reprovadosDisciplina1, reprovadosDisciplina2, reprovadosDisciplina3, reprovadosDisciplina4);

        Files.writeString(pathAprovadosReprovados, conteudo);
    }

    public void classificarAlunosPorResultado(List<Aluno> alunos) throws IOException {
        Path pathAprovadosEmTodas = Path.of("C:\\Users\\conta\\IdeaProjects\\VideoLerCriarDeletarTXT\\src\\AprovadosEmTodas.txt");
        Path pathComReprovacoes = Path.of("C:\\Users\\conta\\IdeaProjects\\VideoLerCriarDeletarTXT\\src\\ComReprova.txt");

        if(Files.notExists(pathAprovadosEmTodas)){
            Files.createFile(pathAprovadosEmTodas);
        }

        if(Files.notExists(pathComReprovacoes)){
            Files.createFile(pathComReprovacoes);
        }

        StringBuilder conteudoAprovados = new StringBuilder("Alunos aprovados em todas as disciplinas:\n");
        StringBuilder conteudoReprovados = new StringBuilder("Alunos com reprova em uma ou mais disciplinas:\n");

        for (Aluno aluno : alunos) {
            boolean aprovadoEmTodas = aluno.notas.stream().allMatch(nota -> nota >= 70);
            if (aprovadoEmTodas) {
                conteudoAprovados.append("ID: ").append(aluno.id).append(" Notas: ").append(aluno.notas).append("\n");
            } else {
                conteudoReprovados.append("ID: ").append(aluno.id).append(" Notas: ").append(aluno.notas).append("\n");
            }
        }

        Files.writeString(pathAprovadosEmTodas, conteudoAprovados.toString());
        Files.writeString(pathComReprovacoes, conteudoReprovados.toString());
    }

    public void calcularMediaMedianaDesvioGeral(List<Aluno> alunos) throws IOException {
        Path path = Path.of("C:\\Users\\conta\\IdeaProjects\\VideoLerCriarDeletarTXT\\src\\MediaMedianaDesvioGeral.txt");
        if(Files.notExists(path)){
            Files.createFile(path);
        }
        List<Integer> mediana1 = new ArrayList<>();
        List<Integer> mediana2 = new ArrayList<>();
        List<Integer> mediana3 = new ArrayList<>();
        List<Integer> mediana4 = new ArrayList<>();

        int contador = 0;
        double soma1 = 0;
        double soma2 = 0;
        double soma3 = 0;
        double soma4 = 0;

        for (Aluno aluno : alunos) {
            aluno.notas.get(0);
            soma1 += aluno.notas.get(0);
            mediana1.add(aluno.notas.get(0));
            aluno.notas.get(1);
            soma2 += aluno.notas.get(1);
            mediana2.add(aluno.notas.get(1));
            aluno.notas.get(2);
            soma3 += aluno.notas.get(2);
            mediana3.add(aluno.notas.get(2));
            aluno.notas.get(3);
            soma4 += aluno.notas.get(3);
            mediana4.add(aluno.notas.get(3));
            contador++;
        }
        double media1 = soma1 / contador;
        double media2 = soma2 / contador;
        double media3 = soma3 / contador;
        double media4 = soma4 / contador;

        mediana1.sort(null);
        mediana2.sort(null);
        mediana3.sort(null);
        mediana4.sort(null);

        double resMediana1 = calcularMediana(mediana1);
        double resMediana2 = calcularMediana(mediana2);
        double resMediana3 = calcularMediana(mediana3);
        double resMediana4 = calcularMediana(mediana4);

        double desvioPadrao1 = calcularDesvioPadrao(mediana1, media1);
        double desvioPadrao2 = calcularDesvioPadrao(mediana2, media2);
        double desvioPadrao3 = calcularDesvioPadrao(mediana3, media3);
        double desvioPadrao4 = calcularDesvioPadrao(mediana4, media4);

        String conteudo = "Todos os Anos: \n" +
                          "Média, Mediana e Desvio Padrão: \n" +
                          "Media1: " + media1 + " | Mediana1: " + resMediana1 + " | Desvio Padrão: " + desvioPadrao1 + "\n" +
                          "Media2: " + media2 + " | Mediana2: " + resMediana2 + " | Desvio Padrão: " + desvioPadrao2 + "\n" +
                          "Media3: " + media3 + " | Mediana3: " + resMediana3 + " | Desvio Padrão: " + desvioPadrao3 + "\n" +
                          "Media4: " + media4 + " | Mediana4: " + resMediana4 + " | Desvio Padrão: " + desvioPadrao4 + "\n";

        Files.writeString(path, conteudo);
    }

    public double calcularMediana(List<Integer> valores) {
        int tamanho = valores.size();
        if (tamanho % 2 == 0) {
            return (valores.get(tamanho / 2 - 1) + valores.get(tamanho / 2)) / 2.0;
        } else {
            return valores.get(tamanho / 2);
        }
    }

    public double calcularDesvioPadrao(List<Integer> valores, double media) {
        double somaDiferencasQuadradas = 0.0;
        for (Integer valor : valores) {
            somaDiferencasQuadradas += Math.pow(valor - media, 2);
        }
        double mediaDiferencasQuadradas = somaDiferencasQuadradas / valores.size();
        return Math.sqrt(mediaDiferencasQuadradas);
    }

    public void calcularMediaMedianaDesvioPorAno(List<Aluno> alunos) throws IOException {
        Path path = Path.of("C:\\Users\\conta\\IdeaProjects\\VideoLerCriarDeletarTXT\\src\\MediaMedianaDesvioGeralPorAno.txt");
        if(Files.notExists(path)){
            Files.createFile(path);
        }

        Map<Integer, List<Aluno>> alunosPorAno = alunos.stream().collect(Collectors.groupingBy(aluno -> aluno.ano));

        StringBuilder conteudo = new StringBuilder();

        for (Map.Entry<Integer, List<Aluno>> entrada : alunosPorAno.entrySet()) {
            int ano = entrada.getKey();
            List<Aluno> alunosDoAno = entrada.getValue();

            double media1 = alunosDoAno.stream().mapToDouble(a -> a.notas.get(0)).average().orElse(0);
            double media2 = alunosDoAno.stream().mapToDouble(a -> a.notas.get(1)).average().orElse(0);
            double media3 = alunosDoAno.stream().mapToDouble(a -> a.notas.get(2)).average().orElse(0);
            double media4 = alunosDoAno.stream().mapToDouble(a -> a.notas.get(3)).average().orElse(0);

            List<Integer> mediana1 = alunosDoAno.stream().map(a -> a.notas.get(0)).collect(Collectors.toList());
            List<Integer> mediana2 = alunosDoAno.stream().map(a -> a.notas.get(1)).collect(Collectors.toList());
            List<Integer> mediana3 = alunosDoAno.stream().map(a -> a.notas.get(2)).collect(Collectors.toList());
            List<Integer> mediana4 = alunosDoAno.stream().map(a -> a.notas.get(3)).collect(Collectors.toList());

            double resMediana1 = calcularMediana(mediana1);
            double resMediana2 = calcularMediana(mediana2);
            double resMediana3 = calcularMediana(mediana3);
            double resMediana4 = calcularMediana(mediana4);

            double desvioPadrao1 = calcularDesvioPadrao(mediana1, media1);
            double desvioPadrao2 = calcularDesvioPadrao(mediana2, media2);
            double desvioPadrao3 = calcularDesvioPadrao(mediana3, media3);
            double desvioPadrao4 = calcularDesvioPadrao(mediana4, media4);

            conteudo.append("Ano: ").append(ano).append("\n")
                    .append("Media1: ").append(media1).append(" | Mediana1: ").append(resMediana1).append(" | Desvio Padrão: ").append(desvioPadrao1).append("\n")
                    .append("Media2: ").append(media2).append(" | Mediana2: ").append(resMediana2).append(" | Desvio Padrão: ").append(desvioPadrao2).append("\n")
                    .append("Media3: ").append(media3).append(" | Mediana3: ").append(resMediana3).append(" | Desvio Padrão: ").append(desvioPadrao3).append("\n")
                    .append("Media4: ").append(media4).append(" | Mediana4: ").append(resMediana4).append(" | Desvio Padrão: ").append(desvioPadrao4).append("\n")
                    .append("----------------------------------------------------------------------------------------").append("\n");

            Files.writeString(path, conteudo);
        }
    }
}