package ru.artyushov.jmhPlugin;

import com.intellij.codeInsight.template.Expression;
import com.intellij.codeInsight.template.Template;
import com.intellij.codeInsight.template.TemplateManager;
import com.intellij.codeInsight.template.impl.ConstantNode;
import com.intellij.psi.PsiClass;

/**
 * User: nikart
 * Date: 18/03/14
 * Time: 13:01
 */
public class BenchmarkMethodTemplate {

    public static Template create(PsiClass psiClass) {
        Template template = TemplateManager.getInstance(psiClass.getProject()).createTemplate("", "");
        template.addTextSegment("@org.openjdk.jmh.annotations.GenerateMicroBenchmark\n");
        template.addTextSegment("public ");
        Expression typeExpr = new ConstantNode("void");
        template.addVariable("type", typeExpr, typeExpr, true);

        template.addTextSegment(" measure");
        Expression nameExpr = new ConstantNode("Name");
        template.addVariable("name", nameExpr, nameExpr, true);
        template.addTextSegment("() {\n}");

        template.setToIndent(true);
        template.setToReformat(true);
        template.setToShortenLongNames(true);

        return template;
    }
}