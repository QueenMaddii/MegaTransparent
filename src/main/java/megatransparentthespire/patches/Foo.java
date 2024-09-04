package megatransparentthespire.patches;

import org.lwjgl.glfw.GLFW;

public class Foo
{
    public static void bar()
    {
        GLFW.glfwWindowHint(GLFW.GLFW_TRANSPARENT_FRAMEBUFFER, GLFW.GLFW_TRUE);
    }
}
