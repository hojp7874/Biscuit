<template>

  <div>
    
    <div class="page-header clear-filter" filter-color="orange">
      <parallax
        class="page-header-image"
        style="background-image:url('img/header.jpg')"
      >
      </parallax>
      <div class="container">
          
        <div class="content-center brand">
          <img class="n-logo" src="img/bisWhite.png" alt="" />
          <h1 class="h1-seo">아직까지 혼자 공부하세요?</h1>
          <h3>비스킷에서 전국 39291개의 스터디를 찾고 함께 공부하세요</h3>
        </div>
       
      </div>



      

      
    </div>


    <div class="main">
      <div class="section section-images">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="hero-images-container">
                <img src="img/Group 38.png" alt="" />
              </div>
         
              <div class="hero-images-container-2">
                <h1>스터디원</h1>
                <h2>모집부터</h2>
                <h2>스터디 관리까지</h2>
                <h2>한번에.</h2>
              </div>
            </div>

            <div class="col-md-12">
           
             
         
              <div class="hero-images-container-3">
                <h1>비대면 시대에도 편리하게 스터디.</h1>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="section section-images">

      <div class="col-md-8">
           
              <div class="hero-images-container">
                <img src="img/frame2md.png" alt="" />
              </div>
         
              <div class="hero-images-container-2">
                <h1>비대면 시대에도 편리하게 스터디.</h1>
              </div>
      </div>
    </div>

     <carousel-section></carousel-section>
 

    <basic-elements></basic-elements>
    <navigation></navigation>
    <tabs-section></tabs-section>
    <progress-pagination></progress-pagination>
    <notifications></notifications>
    <typography></typography>
    <javascript-components></javascript-components>
    <carousel-section></carousel-section>
    <nucleo-icons-section></nucleo-icons-section>
    <div class="section">
      <div class="container text-center">
        <div class="row justify-content-md-center">
          <div class="col-md-12 col-lg-8">
            <h2 class="title">Completed with examples</h2>
            <h5 class="description">
              The kit comes with three pre-built pages to help you get started
              faster. You can change the text and images and you're good to go.
              More importantly, looking at them will give you a picture of what
              you can built with this powerful Bootstrap 4 ui kit.
            </h5>
          </div>
        </div>
      </div>
    </div>
    <signup-form></signup-form>
    <examples-section></examples-section>
    <download-section></download-section>
  </div>
</template>
<script>
import { Parallax } from '@/components';
import BasicElements from './components/BasicElementsSection';
import Navigation from './components/Navigation';
import TabsSection from './components/Tabs';
import ProgressPagination from './components/ProgressPagination';
import Notifications from './components/Notifications';
import Typography from './components/Typography';
import JavascriptComponents from './components/JavascriptComponents';
import CarouselSection from './components/CarouselSection';
import NucleoIconsSection from './components/NucleoIconsSection';
import SignupForm from './components/SignupForm';
import ExamplesSection from './components/ExamplesSection';
import DownloadSection from './components/DownloadSection';

export default {
  name: 'index',
  bodyClass: 'index-page',
  components: {
    Parallax,
    BasicElements,
    Navigation,
    TabsSection,
    ProgressPagination,
    Notifications,
    Typography,
    JavascriptComponents,
    CarouselSection,
    NucleoIconsSection,
    SignupForm,
    ExamplesSection,
    DownloadSection
  }
};
</script>
<style></style>
