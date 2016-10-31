package config;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//                auth.jdbcAuthentication().dataSource(dataSource)
//                        .usersByUsernameQuery(
//                                "select email, wachtwoord from Beheerder where email=?");

        auth.inMemoryAuthentication()
                .withUser("username").password("123456").roles("HOOFDBEHEERDER").and()
                .withUser("424698mv").password("maarten").roles("HOOFDBEHEERDER").and()
                .withUser("427260rv").password("remko").roles("HOOFDBEHEERDER").and()
                .withUser("pol").password("pol").roles("HOOFDBEHEERDER").and()
                .withUser("thomas").password("thomas").roles("HOOFDBEHEERDER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().
                defaultSuccessUrl("/welcome");

        http.authorizeRequests()
                .antMatchers("/welcome*").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
        http.formLogin().
                defaultSuccessUrl("/welcome").
                loginPage("/login");

        http.authorizeRequests()
                .antMatchers("/welcome*").hasRole("HOOFDBEHEERDER").
              and().csrf();
 
    }
    
//    private void inloggen()
//    {
//        JsonObject obj = null;
//        if (this.txfEmail.getText().trim().isEmpty() || this.txfWachtwoord.getText().trim().isEmpty())
//        {
//            lblError.setText("Gelieve een geldige combinatie in te geven.");
//        } else
//        {
//            String passwordEncrypted = sha256(this.txfWachtwoord.getText());
//            try
//            {
//                URL url = new URL("https://studservice.hogent.be/auth/" + this.txfEmail.getText() + "/" + passwordEncrypted);
//
//                try (InputStream is = url.openStream(); JsonReader reader = Json.createReader(is);)
//                {
//                    if (reader == null)
//                    {
//                        lblError.setText("Gelieve een geldige combinatie in te geven.");
//                        return;
//                    }
//                    obj = reader.readObject();
//                } catch (IOException ex)
//                {
//                } catch (JsonParsingException jex)
//                {
//                    lblError.setText("Gelieve een geldige combinatie in te geven.");
//                    return;
//                }
//            } catch (MalformedURLException ex)
//            {
//                Logger.getLogger(LoginPaneelController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println(obj.get("VOORNAAM"));
//            System.out.println(obj.get("NAAM"));
//            System.out.println(obj.get("FACULTEIT"));
//            System.out.println(obj.get("TYPE"));
//            System.out.println(obj.get("EMAIL"));
//            Beheerder user = null;
//            try
//            {
//                user = em.createNamedQuery("Beheerder.geefBeheerderMetEmail", Beheerder.class).setParameter("email", obj.getString("EMAIL")).getSingleResult();
//            } catch (NoResultException nrex)
//            {
//                System.out.println("NIET GEVONDEN IN DATABANK");
//                lblError.setText("U hebt niet de nodige rechten gekregen. Contacteer de hoofdbeheerder.");
//                return;
//            }
//            Scene scene = new Scene(new ContainerController(stage, user));
//            stage.setScene(scene);
//            
//        }
//    }

    private String sha256(String base)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++)
            {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex)
        {

        }
        return "";
    }
}
