package jw.frontend.main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameMenus
{
    public static JMenuBar addAllMenus()
    {
        JMenuBar bar = new JMenuBar();
        addMenus(bar);
        return bar;
    }
    
    public static void addMenus(JMenuBar bar)
    {
        JMenu menu_file = new JMenu("File");
        JMenu menu_edit = new JMenu("Edit");
        JMenu menu_resources = new JMenu("Resources");
        JMenu menu_manage = new JMenu("Manage");
        JMenu menu_help = new JMenu("Help");
        addFileMenuItems(menu_file);
        addEditMenuItems(menu_edit);
        addResourcesMenuItems(menu_resources);
        addManageMenuItems(menu_manage);
        addHelpMenuItems(menu_help);
        bar.add(menu_file);
        bar.add(menu_edit);
        bar.add(menu_resources);
        bar.add(menu_manage);
        bar.add(menu_help);
    }
    
    public static void addFileMenuItems(JMenu menu)
    {
        // ADD MENU ITEMS
        JMenuItem item_new = new JMenuItem("New Game");
        JMenuItem item_open = new JMenuItem("Open Game");
        JMenuItem item_save = new JMenuItem("Save Game");
        JMenuItem item_save_as = new JMenuItem("Save Game As...");
        JMenuItem item_import = new JMenuItem("Import");
        JMenuItem item_export = new JMenuItem("Export");
        JMenuItem item_exit = new JMenuItem("Exit");

        // LISTENERS
        item_open.addActionListener(new Listeners.open_game_listener());
        
        menu.add(item_new);
        menu.add(item_open);
        menu.add(item_save);
        menu.add(item_save_as);
        menu.add(item_import);
        menu.add(item_export);
        menu.add(item_exit);
    }
    
    public static void addEditMenuItems(JMenu menu)
    {
        JMenuItem item_duplicate = new JMenuItem("Duplicate");
        JMenuItem item_copy = new JMenuItem("Copy");
        JMenuItem item_paste = new JMenuItem("Paste");
        JMenuItem item_delete = new JMenuItem("Delete");
        JMenuItem item_rename = new JMenuItem("Rename");
        menu.add(item_duplicate);
        menu.add(item_copy);
        menu.add(item_paste);
        menu.add(item_delete);
        menu.add(item_rename);
    }
    
    public static void addResourcesMenuItems(JMenu menu)
    {
        JMenuItem item_new_image = new JMenuItem("New Image");
        JMenuItem item_new_animation = new JMenuItem("New Animation");
        JMenuItem item_new_sound = new JMenuItem("New .WAV Sound");
        menu.add(item_new_image);
        menu.add(item_new_animation);
        menu.add(item_new_sound);
    }
    
    public static void addManageMenuItems(JMenu menu)
    {
        // Manage
        JMenuItem item_jw_manager = new JMenuItem("Asset Manager");
        JMenu item_new_object = new JMenu("New Object...");
        JMenu item_new_background = new JMenu("New Background...");
        JMenu item_new_fixed_background = new JMenu("New Fixed Background");
        JMenu item_new_moving_background = new JMenu("New Moving Background");
        JMenu item_new_parallax_background = new JMenu("New Parallax Background");
        
        // Manage > New Object
        JMenuItem item_new_rigid_object = new JMenuItem("New Rigid Object");
        JMenuItem item_new_animated_object = new JMenuItem("New Animated Object");
        
        // Manage > New Background
        JMenuItem item_new_rigid_background = new JMenuItem("New Rigid Background");
        JMenuItem item_new_animated_background = new JMenuItem("New Animated Background");
        
        // Manage > New Fixed Background
        JMenuItem item_new_rigid_fixed_background = new JMenuItem("New Rigid, Fixed Background");
        JMenuItem item_new_animated_fixed_background = new JMenuItem("New Animated, Fixed Background");
        
        // Manage > New Moving Background
        JMenuItem item_new_rigid_moving_background = new JMenuItem("New Rigid, Moving Background");
        JMenuItem item_new_animated_moving_background = new JMenuItem("New Animated, Moving Background");
        
        // Manage > New Parallax Background
        JMenuItem item_new_rigid_parallax_background = new JMenuItem("New Rigid, Parallax Background");
        JMenuItem item_new_animated_parallax_background = new JMenuItem("New Animated, Parallax Background");
        
        // Add sub-menus
        item_new_object.add(item_new_rigid_object);
        item_new_object.add(item_new_animated_object);
        item_new_background.add(item_new_rigid_background);
        item_new_background.add(item_new_animated_background);
        item_new_fixed_background.add(item_new_rigid_fixed_background);
        item_new_fixed_background.add(item_new_animated_fixed_background);
        item_new_moving_background.add(item_new_rigid_moving_background);
        item_new_moving_background.add(item_new_animated_moving_background);
        item_new_parallax_background.add(item_new_rigid_parallax_background);
        item_new_parallax_background.add(item_new_animated_parallax_background);
        
        // Add all menu items
        menu.add(item_jw_manager);
        menu.add(item_new_object);
        menu.add(item_new_background);
        menu.add(item_new_fixed_background);
        menu.add(item_new_moving_background);
        menu.add(item_new_parallax_background);
    }
    
    public static void addHelpMenuItems(JMenu menu)
    {
        JMenuItem item_about = new JMenuItem("About JW Game Engine");
        menu.add(item_about);
    }
}
